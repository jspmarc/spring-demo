package dev.jspmarc.springdemo.rest.web.model.request;

import com.tiket.tix.common.entity.CommonModel;
import lombok.Data;

@Data
public class FavoriteRequest extends CommonModel {
    private static final long serialVersionUID = 1L;
    private String gitHubLogin;
    private int gitHubId;
}
