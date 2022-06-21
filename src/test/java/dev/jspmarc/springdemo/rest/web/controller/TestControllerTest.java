package dev.jspmarc.springdemo.rest.web.controller;

import dev.jspmarc.springdemo.entity.constant.ApiPath;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class TestControllerTest {
  @InjectMocks
  private TestController testController;

  private MockMvc mockMvc;

  @Test
  public void testTest() throws Exception {
    mockMvc.perform(get(ApiPath.BASE_TEST_PATH))
            .andExpect(status().isIAmATeapot());
  }

  @Before
  public void setUp() {
    initMocks(this);
    mockMvc = standaloneSetup(testController).build();
  }
}