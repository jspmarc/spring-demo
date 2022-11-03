package dev.jspmarc.springdemo.rest.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.jspmarc.springdemo.entity.constant.ApiPath;
import dev.jspmarc.springdemo.entity.constant.ResponseCode;
import dev.jspmarc.springdemo.entity.constant.test.FavoriteTestVariable;
import dev.jspmarc.springdemo.rest.web.model.request.FavoriteRequest;
import dev.jspmarc.springdemo.rest.web.model.response.FavoriteResponse;
import dev.jspmarc.springdemo.service.api.FavoriteService;
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

public class FavoriteControllerTest extends FavoriteTestVariable {

  private final ObjectMapper objectMapper = new ObjectMapper();
  @InjectMocks
  private FavoriteController favoriteController;
  @Mock
  private FavoriteService favoriteService;
  private MockMvc mockMvc;

  @Test
  public void getFavoritesTest() throws Exception {
    List<FavoriteResponse> responses = getFavoriteResponses();
    when(favoriteService.getAll()).thenReturn(Single.just(responses));

    MockHttpServletRequestBuilder builder = MockMvcRequestBuilders
        .get(ApiPath.BASE_FAVORITE_PATH)
        .accept(MediaType.APPLICATION_JSON);

    MvcResult deferredResult = mockMvc.perform(builder).andReturn();
    mockMvc.perform(asyncDispatch(deferredResult))
        .andExpect(status().isOk())
        .andExpect(jsonPath("errors", equalTo(null)))
        .andExpect(jsonPath("code", equalTo(ResponseCode.SUCCESS.getCode())))
        .andExpect(jsonPath("message", equalTo(ResponseCode.SUCCESS.getMessage())))
        .andExpect(jsonPath("data[0].id", equalTo(responses.get(0).getId())))
        .andExpect(jsonPath("data[0].gitHubLogin", equalTo(responses.get(0).getGitHubLogin())))
        .andExpect(jsonPath("data[0].gitHubId", equalTo(responses.get(0).getGitHubId())));

    // make sure getAll service was called
    verify(favoriteService).getAll();
  }

  @Test
  public void favoritesUserTest() throws Exception {
    FavoriteResponse response = getFavoriteResponse();
    FavoriteRequest request = FavoriteRequest.builder()
        .gitHubLogin(response.getGitHubLogin())
        .gitHubId(response.getGitHubId())
        .build();
    when(favoriteService.addToFavorite(request))
        .thenReturn(Single.just(response));

    MockHttpServletRequestBuilder builder = MockMvcRequestBuilders
        .post(ApiPath.BASE_FAVORITE_PATH)
        .accept(MediaType.APPLICATION_JSON)
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(response));

    MvcResult deferredResult = mockMvc.perform(builder).andReturn();
    mockMvc.perform(asyncDispatch(deferredResult))
        .andExpect(status().isCreated())
        .andExpect(jsonPath("errors", equalTo(null)))
        .andExpect(jsonPath("code", equalTo(ResponseCode.SUCCESS.getCode())))
        .andExpect(jsonPath("message", equalTo(ResponseCode.SUCCESS.getMessage())))
        .andExpect(jsonPath("data.id", equalTo(response.getId())))
        .andExpect(jsonPath("data.gitHubLogin", equalTo(response.getGitHubLogin())))
        .andExpect(jsonPath("data.gitHubId", equalTo(response.getGitHubId())));

    // make sure getAll service was called
    verify(favoriteService).addToFavorite(request);
  }

  @Before
  public void setUp() {
    initMocks(this);
    mockMvc = standaloneSetup(favoriteController).build();
  }

  @After
  public void tearDown() {
    verifyNoMoreInteractions(favoriteService);
  }
}