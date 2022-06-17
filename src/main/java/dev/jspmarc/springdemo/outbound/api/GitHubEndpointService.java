package dev.jspmarc.springdemo.outbound.api;

import dev.jspmarc.springdemo.entity.constant.ApiPath;
import dev.jspmarc.springdemo.entity.outbound.GitHubUser;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;

public interface GitHubEndpointService {
    @GET(ApiPath.GITHUB_USERS)
    Call<List<GitHubUser>> getUsers(@Query("since") int since);
}
