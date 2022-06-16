package dev.jspmarc.springdemo.outbound.api;

import dev.jspmarc.springdemo.entity.constant.ApiPath;
import dev.jspmarc.springdemo.entity.dao.GitHubUsersResponse;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GitHubEndpointService {
    @GET(ApiPath.GITHUB_USERS)
    Response<GitHubUsersResponse> getUsers(@Query("since") int since);
}
