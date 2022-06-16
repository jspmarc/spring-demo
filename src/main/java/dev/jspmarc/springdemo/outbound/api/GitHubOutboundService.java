package dev.jspmarc.springdemo.outbound.api;

import dev.jspmarc.springdemo.entity.dao.GitHubUsersResponse;
import io.reactivex.Single;

public interface GitHubOutboundService {
    Single<GitHubUsersResponse> getRandomUsers(int since);
}
