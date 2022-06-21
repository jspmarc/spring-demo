package dev.jspmarc.springdemo.rest.web.model.response;

import com.tiket.tix.common.entity.CommonModel;
import net.karneim.pojobuilder.GeneratePojoBuilder;

@GeneratePojoBuilder
public class GitHubUserResponse extends CommonModel {
  private int gitHubId;
  private String gitHubLogin;

  public int getGitHubId() {
    return gitHubId;
  }

  public void setGitHubId(int gitHubId) {
    this.gitHubId = gitHubId;
  }

  public String getGitHubLogin() {
    return gitHubLogin;
  }

  public void setGitHubLogin(String gitHubLogin) {
    this.gitHubLogin = gitHubLogin;
  }
}
