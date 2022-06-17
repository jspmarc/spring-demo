package dev.jspmarc.springdemo.service.api;

import dev.jspmarc.springdemo.entity.dao.GitHubUser;
import io.reactivex.Single;

import java.util.List;

public interface GitHubService {
    Single<List<GitHubUser>> getRandomUsers();
}
