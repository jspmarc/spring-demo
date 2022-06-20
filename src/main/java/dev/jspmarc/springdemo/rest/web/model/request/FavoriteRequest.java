package dev.jspmarc.springdemo.rest.web.model.request;

import com.tiket.tix.common.entity.CommonModel;
import lombok.Data;
import net.karneim.pojobuilder.GeneratePojoBuilder;

@Data
@GeneratePojoBuilder
public class FavoriteRequest extends CommonModel {
    private static final long serialVersionUID = 1L;
    private String gitHubLogin;
    private int gitHubId;

    public String getGitHubLogin() {
        return gitHubLogin;
    }

    public void setGitHubLogin(String gitHubLogin) {
        this.gitHubLogin = gitHubLogin;
    }

    public int getGitHubId() {
        return gitHubId;
    }

    public void setGitHubId(int gitHubId) {
        this.gitHubId = gitHubId;
    }
}
