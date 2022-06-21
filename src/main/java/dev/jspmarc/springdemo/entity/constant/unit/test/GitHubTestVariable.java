package dev.jspmarc.springdemo.entity.constant.unit.test;

import dev.jspmarc.springdemo.entity.constant.GitHubServiceConstant;
import dev.jspmarc.springdemo.rest.web.model.response.GitHubUserResponse;
import dev.jspmarc.springdemo.rest.web.model.response.GitHubUserResponseBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GitHubTestVariable {
  private final static Random rand = new Random();

  public static GitHubUserResponse getUserResponse() {
    return new GitHubUserResponseBuilder()
            .withGitHubId(rand.nextInt(GitHubServiceConstant.MAX_USER_ID))
            .withGitHubLogin("user" + rand.nextInt(1000))
            .build();
  }

  public static List<GitHubUserResponse> getUserResponses() {
    ArrayList<GitHubUserResponse> list = new ArrayList<>();
    int n;
    do {
      n = rand.nextInt(10);
    } while (n <= 0);
    for (int i = 0; i < n; ++i) {
      list.add(new GitHubUserResponseBuilder()
              .withGitHubId(rand.nextInt(GitHubServiceConstant.MAX_USER_ID))
              .withGitHubLogin("user" + rand.nextInt(1000))
              .build());
    }
    return list;
  }
}
