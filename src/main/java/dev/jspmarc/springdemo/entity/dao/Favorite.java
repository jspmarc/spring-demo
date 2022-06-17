package dev.jspmarc.springdemo.entity.dao;

import com.tiket.tix.hotel.cart.entity.dao.common.BaseMongo;
import dev.jspmarc.springdemo.entity.constant.CollectionName;
import net.karneim.pojobuilder.GeneratePojoBuilder;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = CollectionName.FAVORITE)
@GeneratePojoBuilder
public class Favorite extends BaseMongo {
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
