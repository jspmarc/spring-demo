package dev.jspmarc.springdemo.rest.web.controller;

import dev.jspmarc.springdemo.entity.constant.ApiPath;
import dev.jspmarc.springdemo.entity.constant.ResponseCode;
import dev.jspmarc.springdemo.entity.constant.test.GitHubTestVariable;
import dev.jspmarc.springdemo.rest.web.model.response.GitHubUserResponse;
import dev.jspmarc.springdemo.service.api.GitHubService;
import io.reactivex.Single;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.asyncDispatch;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class GitHubControllerTest extends GitHubTestVariable {

  @InjectMocks
  private GitHubController gitHubController;
  @Mock
  private GitHubService gitHubService;

  private MockMvc mockMvc;

  @Test
  public void getRandomUsers() throws Exception {
    List<GitHubUserResponse> responses = getUserResponses();
    when(gitHubService.getRandomUsers())
            .thenReturn(Single.just(responses));

    MockHttpServletRequestBuilder builder = MockMvcRequestBuilders
            .get(ApiPath.BASE_GITHUB_PATH + ApiPath.GITHUB_USERS)
            .accept(MediaType.APPLICATION_JSON);

    MvcResult deferredResult = mockMvc.perform(builder).andReturn();
    mockMvc.perform(asyncDispatch(deferredResult))
            .andExpect(status().isOk())
            .andExpect(jsonPath("errors", equalTo(null)))
            .andExpect(jsonPath("code", equalTo(ResponseCode.SUCCESS.getCode())))
            .andExpect(jsonPath("message", equalTo(ResponseCode.SUCCESS.getMessage())));

    verify(gitHubService).getRandomUsers();
  }

  @Before
  public void setUp() {
    initMocks(this);
    mockMvc = standaloneSetup(gitHubController).build();
  }

  @After
  public void tearDown() {
    verifyNoMoreInteractions(gitHubService);
  }
}