package dev.jspmarc.springdemo.entity.dao;

import com.tiket.tix.common.entity.CommonModel;

import java.util.List;

public class GitHubUsersResponse extends CommonModel {

    private List<GitHubUser> data;

    public List<GitHubUser> getData() {
        return data;
    }

    @Override
    public String toString() {
        return "GitHubUsersResponse{" +
                "data=" + data +
                '}';
    }
}
