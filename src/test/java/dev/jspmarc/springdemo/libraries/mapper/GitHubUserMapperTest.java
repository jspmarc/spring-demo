package dev.jspmarc.springdemo.libraries.mapper;

import dev.jspmarc.springdemo.entity.outbound.GitHubUser;
import dev.jspmarc.springdemo.rest.web.model.response.GitHubUserResponse;
import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

public class GitHubUserMapperTest {

  private static final Random rand = new Random();

  @Test
  public void toGitHubUserResponseTest() {
    GitHubUser expected = GitHubUser.builder()
        .id(rand.nextInt())
        .login("user" + rand.nextInt())
        .build();
    GitHubUserResponse actual = GitHubUserMapper.toGitHubUserResponse(expected);
    Assert.assertEquals(expected.getId(), actual.getGitHubId());
    Assert.assertEquals(expected.getLogin(), actual.getGitHubLogin());
  }
}