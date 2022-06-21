package dev.jspmarc.springdemo.service.impl;

import dev.jspmarc.springdemo.entity.constant.GitHubServiceConstant;
import dev.jspmarc.springdemo.outbound.api.GitHubOutboundService;
import dev.jspmarc.springdemo.rest.web.model.response.GitHubUserResponse;
import dev.jspmarc.springdemo.service.api.GitHubService;
import io.reactivex.Single;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class GitHubServiceImpl implements GitHubService {
  private final GitHubOutboundService gitHubOutboundService;

  @Autowired
  public GitHubServiceImpl(GitHubOutboundService gitHubOutboundService) {
    this.gitHubOutboundService = gitHubOutboundService;
  }

  @Override
  public Single<List<GitHubUserResponse>> getRandomUsers() {
    Random random = new Random();
    int since = random.nextInt(GitHubServiceConstant.MAX_USER_ID);
    return gitHubOutboundService.getRandomUsers(since).onErrorReturnItem(new ArrayList<>());

  }
}
