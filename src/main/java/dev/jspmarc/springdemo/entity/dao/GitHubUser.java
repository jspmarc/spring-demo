package dev.jspmarc.springdemo.entity.dao;

import com.tiket.tix.common.entity.CommonModel;
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import net.karneim.pojobuilder.GeneratePojoBuilder;

//@GeneratePojoBuilder
//@JsonIgnoreProperties(ignoreUnknown = true)
public class GitHubUser extends CommonModel {
    private String login;
    private int id;
}
