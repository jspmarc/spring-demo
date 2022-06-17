package dev.jspmarc.springdemo.rest.web.model.response;

import com.tiket.tix.common.entity.CommonModel;
import lombok.NoArgsConstructor;
import net.karneim.pojobuilder.GeneratePojoBuilder;

@NoArgsConstructor
@GeneratePojoBuilder
public class GitHubUserResponse extends CommonModel {
    private long githubId;
    private String githubLogin;

    public long getGithubId() {
        return githubId;
    }

    public void setGithubId(long githubId) {
        this.githubId = githubId;
    }

    public String getGithubLogin() {
        return githubLogin;
    }

    public void setGithubLogin(String githubLogin) {
        this.githubLogin = githubLogin;
    }
}
