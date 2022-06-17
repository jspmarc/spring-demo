package dev.jspmarc.springdemo.outbound.api;

import dev.jspmarc.springdemo.entity.outbound.GitHubUser;
import dev.jspmarc.springdemo.libraries.mapper.GitHubUserMapper;
import dev.jspmarc.springdemo.rest.web.model.response.GitHubUserResponse;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class GitHubOutboundServiceImpl implements GitHubOutboundService {
    private final GitHubEndpointService endpointService;
    private final Scheduler scheduler;

    @Autowired
    public GitHubOutboundServiceImpl(GitHubEndpointService gitHubEndpointService, Scheduler gitHubScheduler) {
        this.endpointService = gitHubEndpointService;
        this.scheduler = gitHubScheduler;
    }

    @Override
    public Single<List<GitHubUserResponse>> getRandomUsers(int since) {
        return Single.<List<GitHubUserResponse>>create(singleEmitter -> {
                    try {
                        Response<List<GitHubUser>> response = endpointService.getUsers(since).execute();
                        if (response.isSuccessful()) {
                            List<GitHubUserResponse> res;
                            if (response.body() != null) {
                                res = response
                                        .body()
                                        .stream()
                                        .map(GitHubUserMapper::toGitHubUserResponse)
                                        .collect(Collectors.toList());
                            } else {
                                res = new ArrayList<>();
                            }
                            singleEmitter.onSuccess(res);
                            return;
                        }
                        if (Objects.nonNull(response.errorBody())) {
                            singleEmitter.onError(new Exception(response.errorBody().string()));
                            return;
                        }
                        singleEmitter.onError(new Exception("Unknown error"));
                    } catch (Exception e) {
                        System.err.println("Call failed: " + e);
                    }

                    singleEmitter.onSuccess(new ArrayList<>());
                })
                .doOnError(System.err::println)
                .onErrorResumeNext(Single::error)
                .subscribeOn(scheduler);
    }
}
