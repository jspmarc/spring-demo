package dev.jspmarc.springdemo.libraries.mapper;

import dev.jspmarc.springdemo.entity.dao.GitHubUser;
import dev.jspmarc.springdemo.rest.web.model.response.GitHubUserResponse;
import dev.jspmarc.springdemo.rest.web.model.response.GitHubUserResponseBuilder;

public class GitHubUserMapper {
    public static GitHubUserResponse toGitHubUserResponse(GitHubUser ghu) {
        return new GitHubUserResponseBuilder()
                .withGithubId(ghu.getId())
                .withGithubLogin(ghu.getLogin())
                .build();
    }
}
