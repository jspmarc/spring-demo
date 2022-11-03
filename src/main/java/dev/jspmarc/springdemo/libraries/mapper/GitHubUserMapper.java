package dev.jspmarc.springdemo.libraries.mapper;

import dev.jspmarc.springdemo.entity.outbound.GitHubUser;
import dev.jspmarc.springdemo.rest.web.model.response.GitHubUserResponse;

public class GitHubUserMapper {

  public static GitHubUserResponse toGitHubUserResponse(GitHubUser ghu) {
    return GitHubUserResponse.builder()
        .gitHubId(ghu.getId())
        .gitHubLogin(ghu.getLogin())
        .build();
  }
}
