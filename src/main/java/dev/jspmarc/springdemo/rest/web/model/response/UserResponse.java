package dev.jspmarc.springdemo.rest.web.model.response;

import com.tiket.tix.common.entity.CommonModel;
import lombok.Data;

@Data
public class UserResponse extends CommonModel {
    private String id;
    private long githubId;
    private String githubLogin;
}
