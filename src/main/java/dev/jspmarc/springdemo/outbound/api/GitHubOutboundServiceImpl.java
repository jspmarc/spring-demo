package dev.jspmarc.springdemo.outbound.api;

import dev.jspmarc.springdemo.entity.constant.GitHubServiceConstant;
import dev.jspmarc.springdemo.entity.outbound.GitHubUser;
import dev.jspmarc.springdemo.libraries.mapper.GitHubUserMapper;
import dev.jspmarc.springdemo.rest.web.model.response.GitHubUserResponse;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Slf4j
public class GitHubOutboundServiceImpl implements GitHubOutboundService {

  private final GitHubEndpointService endpointService;
  private final Scheduler scheduler;

  @Autowired
  public GitHubOutboundServiceImpl(GitHubEndpointService gitHubEndpointService,
      Scheduler gitHubScheduler) {
    this.endpointService = gitHubEndpointService;
    this.scheduler = gitHubScheduler;
  }

  @Override
  public Single<List<GitHubUserResponse>> getRandomUsers(int since) {
    return Single.fromCallable(() -> {
          try {
            Response<List<GitHubUser>> response = endpointService.getUsers(since,
                GitHubServiceConstant.RESULT_COUNT).execute();
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
              return res;
            }
            if (Objects.nonNull(response.errorBody())) {
              throw new Exception(response.errorBody().string());
            }
            throw new Exception("Unknown error");
          } catch (Exception e) {
            log.error("get random users failed", e);
          }

          return new ArrayList<GitHubUserResponse>();
        })
        .doOnError(e -> log.error("get random users failed", e))
        .onErrorResumeNext(Single::error)
        .subscribeOn(scheduler);
  }
}
