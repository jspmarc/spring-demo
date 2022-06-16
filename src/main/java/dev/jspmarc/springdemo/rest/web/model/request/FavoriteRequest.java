package dev.jspmarc.springdemo.rest.web.model.request;

import com.tiket.tix.common.entity.CommonModel;

public class FavoriteRequest extends CommonModel {
    private static final long serialVersionUID = 1L;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserRequest{" +
                "name='" + name + '\'' +
                '}';
    }
}
