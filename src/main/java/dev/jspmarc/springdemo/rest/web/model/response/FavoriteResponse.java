package dev.jspmarc.springdemo.rest.web.model.response;

import com.tiket.tix.common.entity.CommonModel;
import net.karneim.pojobuilder.GeneratePojoBuilder;

@GeneratePojoBuilder
public class FavoriteResponse extends CommonModel {
    private String id;
    private int gitHubId;
    private String gitHubLogin;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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
