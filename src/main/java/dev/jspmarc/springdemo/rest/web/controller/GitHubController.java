package dev.jspmarc.springdemo.rest.web.controller;

import com.tiket.tix.common.rest.web.model.response.BaseResponse;
import com.tiket.tix.common.rest.web.model.response.CommonResponse;
import com.tiket.tix.hotel.common.model.enums.ResponseCode;
import dev.jspmarc.springdemo.entity.constant.ApiPath;
import dev.jspmarc.springdemo.rest.web.model.response.GitHubUserResponse;
import dev.jspmarc.springdemo.service.api.GitHubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.List;

@RestController
@RequestMapping(ApiPath.BASE_GITHUB_PATH)
public class GitHubController {

  private final GitHubService gitHubService;

  @Autowired
  public GitHubController(GitHubService gitHubService) {
    this.gitHubService = gitHubService;
  }

  @GetMapping(ApiPath.GITHUB_USERS)
  public DeferredResult<BaseResponse<List<GitHubUserResponse>>> getRandomUsers() {
    DeferredResult<BaseResponse<List<GitHubUserResponse>>> result = new DeferredResult<>();

    gitHubService
            .getRandomUsers()
            .map(users -> CommonResponse.constructResponse(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage(), null, users))
            .subscribe(result::setResult, result::setErrorResult);

    return result;
  }
}
