package dev.jspmarc.springdemo.service.api;

import dev.jspmarc.springdemo.entity.dao.GitHubUsersResponse;
import io.reactivex.Single;

public interface GitHubService {
    Single<GitHubUsersResponse> getRandomUsers();
}
