package dev.jspmarc.springdemo.outbound.api;

import dev.jspmarc.springdemo.entity.dao.GitHubUser;
import io.reactivex.Single;

import java.util.List;

public interface GitHubOutboundService {
    Single<List<GitHubUser>> getRandomUsers(int since);
}
