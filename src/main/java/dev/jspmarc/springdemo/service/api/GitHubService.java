package dev.jspmarc.springdemo.service.api;

import dev.jspmarc.springdemo.rest.web.model.response.GitHubUserResponse;
import io.reactivex.Single;

import java.util.List;

public interface GitHubService {
  Single<List<GitHubUserResponse>> getRandomUsers();
}
