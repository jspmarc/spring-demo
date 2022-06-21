package dev.jspmarc.springdemo.service.impl;

import dev.jspmarc.springdemo.entity.constant.GitHubServiceConstant;
import dev.jspmarc.springdemo.entity.constant.unit.test.GitHubTestVariable;
import dev.jspmarc.springdemo.outbound.api.GitHubOutboundService;
import dev.jspmarc.springdemo.rest.web.model.response.GitHubUserResponse;
import io.reactivex.Single;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;

@RunWith(PowerMockRunner.class)
public class GitHubServiceImplTest extends GitHubTestVariable implements GitHubServiceConstant {

    @InjectMocks
    private GitHubServiceImpl gitHubService;

    @Mock
    private GitHubOutboundService gitHubOutboundService;

    @Test
    public void getRandomUsersTest() {
        ArrayList<GitHubUserResponse> gitHubUsers = new ArrayList<>(RESULT_COUNT);
        for (int i = 0; i < RESULT_COUNT; i++) {
            gitHubUsers.add(getUserResponse());
        }
        when(gitHubOutboundService.getRandomUsers(anyInt()))
                .thenReturn(Single.just(gitHubUsers));

        gitHubService.getRandomUsers().test().assertValue(gitHubUsers);

        // verify outbound service is called exactly once
        verify(gitHubOutboundService).getRandomUsers(anyInt());
    }

    @Test
    public void getRandomUsersTestFailCase() {
        when(gitHubOutboundService.getRandomUsers(anyInt()))
                .thenReturn(Single.just(new ArrayList<>()));

        gitHubService.getRandomUsers().test().assertValue(v -> v.size() == 0);

        // verify outbound service is called exactly once
        verify(gitHubOutboundService).getRandomUsers(anyInt());
    }

    @After
    public void tearDown() {
        verifyNoMoreInteractions(gitHubOutboundService);
    }
}