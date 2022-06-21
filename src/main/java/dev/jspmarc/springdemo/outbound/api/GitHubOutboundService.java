package dev.jspmarc.springdemo.outbound.api;

import dev.jspmarc.springdemo.rest.web.model.response.GitHubUserResponse;
import io.reactivex.Single;

import java.util.List;

public interface GitHubOutboundService {
  Single<List<GitHubUserResponse>> getRandomUsers(int since);
}
