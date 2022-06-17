package dev.jspmarc.springdemo.service.impl;

import dev.jspmarc.springdemo.outbound.api.GitHubOutboundService;
import dev.jspmarc.springdemo.rest.web.model.response.GitHubUserResponse;
import dev.jspmarc.springdemo.service.api.GitHubService;
import io.reactivex.Single;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GitHubServiceImpl implements GitHubService {
    private final GitHubOutboundService gitHubOutboundService;

    @Autowired
    public GitHubServiceImpl(GitHubOutboundService gitHubOutboundService) {
        this.gitHubOutboundService = gitHubOutboundService;
    }

    @Override
    public Single<List<GitHubUserResponse>> getRandomUsers() {
        return gitHubOutboundService.getRandomUsers(10).onErrorReturnItem(new ArrayList<>());
    }
}
