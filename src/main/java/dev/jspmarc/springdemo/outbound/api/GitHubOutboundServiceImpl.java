package dev.jspmarc.springdemo.outbound.api;

import dev.jspmarc.springdemo.entity.dao.GitHubUsersResponse;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import org.springframework.beans.factory.annotation.Autowired;
import retrofit2.Response;

import java.util.Objects;

public class GitHubOutboundServiceImpl implements GitHubOutboundService {
    private final GitHubEndpointService endpointService;
    private final Scheduler scheduler;

    @Autowired
    public GitHubOutboundServiceImpl(GitHubEndpointService endpointService, Scheduler scheduler) {
        this.endpointService = endpointService;
        this.scheduler = scheduler;
    }

    @Override
    public Single<GitHubUsersResponse> getRandomUsers(int since) {
        return Single.<GitHubUsersResponse>create(singleEmitter -> {
                    try {
                        Response<GitHubUsersResponse> response = endpointService.getUsers(since);
                        if (response.isSuccessful()) {
                            singleEmitter.onSuccess(response.body());
                            return;
                        }
                        if (Objects.nonNull(response.errorBody())) {
                            singleEmitter.onError(new Exception(response.errorBody().string()));
                            return;
                        }
                        singleEmitter.onError(new Exception("Unknown error"));
                    } catch (Exception e) {
                        // TODO: Do something
                    }

                    singleEmitter.onSuccess(new GitHubUsersResponse());
                })
                .doOnError(System.err::println)
                .onErrorResumeNext(Single::error)
                .subscribeOn(scheduler);
    }
}
