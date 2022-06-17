package dev.jspmarc.springdemo.entity.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tiket.tix.common.entity.CommonModel;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GitHubUser extends CommonModel {
    private String login;
    private int id;
}
