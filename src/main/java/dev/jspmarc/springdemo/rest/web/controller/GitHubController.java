package dev.jspmarc.springdemo.rest.web.controller;

import dev.jspmarc.springdemo.entity.constant.ApiPath;
import dev.jspmarc.springdemo.rest.web.model.response.GitHubUserResponse;
import dev.jspmarc.springdemo.service.api.GitHubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.List;

@RestController
@RequestMapping(ApiPath.BASE_GITHUB_PATH)
public class GitHubController {

    private final GitHubService gitHubService;

    @Autowired
    public GitHubController(GitHubService gitHubService) {
        this.gitHubService = gitHubService;
    }

    @GetMapping(ApiPath.ROOT)
    public DeferredResult<List<GitHubUserResponse>> getRandomUsers() {
        DeferredResult<List<GitHubUserResponse>> result = new DeferredResult<>();

        gitHubService.getRandomUsers().subscribe(result::setResult, result::setErrorResult);

        return result;
    }
}
