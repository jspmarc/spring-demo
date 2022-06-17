package dev.jspmarc.springdemo.service.impl;

import dev.jspmarc.springdemo.entity.dao.GitHubUsersResponse;
import dev.jspmarc.springdemo.outbound.api.GitHubOutboundService;
import dev.jspmarc.springdemo.service.api.GitHubService;
import io.reactivex.Single;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GitHubServiceImpl implements GitHubService {
    private final GitHubOutboundService gitHubOutboundService;

    @Autowired
    public GitHubServiceImpl(GitHubOutboundService gitHubOutboundService) {
        this.gitHubOutboundService = gitHubOutboundService;
    }

    @Override
    public Single<GitHubUsersResponse> getRandomUsers() {
        return gitHubOutboundService.getRandomUsers(10).onErrorReturnItem(new GitHubUsersResponse());
    }
}
