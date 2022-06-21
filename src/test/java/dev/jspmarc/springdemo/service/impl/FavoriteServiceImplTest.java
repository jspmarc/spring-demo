package dev.jspmarc.springdemo.service.impl;

import dev.jspmarc.springdemo.dao.api.FavoriteRepository;
import dev.jspmarc.springdemo.entity.constant.unit.test.FavoriteTestVariable;
import dev.jspmarc.springdemo.entity.dao.Favorite;
import dev.jspmarc.springdemo.rest.web.model.request.FavoriteRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(PowerMockRunner.class)
public class FavoriteServiceImplTest extends FavoriteTestVariable {

  @InjectMocks
  FavoriteServiceImpl favoriteService;

  @Mock
  FavoriteRepository favoriteRepository;

  @Test
  public void getAllTest() {
    // setup repo result
    List<Favorite> favorites = getFavorites();
    when(favoriteRepository.findAll()).thenReturn(favorites);

    // test results are the same
    favoriteService.getAll().test().assertValue(favoriteResponses -> {
      boolean allSame = true;
      for (int i = 0; i < favoriteResponses.size() && allSame; ++i) {
        allSame = favoriteResponses.get(i).getGitHubId() == favorites.get(i).getGitHubId()
                && favoriteResponses.get(i).getGitHubLogin().equals(favorites.get(i).getGitHubLogin())
                && favoriteResponses.get(i).getId().equals(favorites.get(i).getId());
      }
      return allSame;
    });

    // verify findAll is called exactly once
    verify(favoriteRepository).findAll();
    verifyNoMoreInteractions(favoriteRepository);
  }

  @Test
  public void addToFavoriteTest() {
    // setup repo result
    Favorite favorite = getFavorite();
    when(favoriteRepository.insert((Favorite) anyObject())).thenReturn(favorite);

    // then create request with the same id and login
    FavoriteRequest favoriteRequest = getFavoriteRequest(favorite.getGitHubId(), favorite.getGitHubLogin());

    // test result is the same
    favoriteService
            .addToFavorite(favoriteRequest)
            .test()
            .assertValue(f -> f.getGitHubId() == favorite.getGitHubId()
                    && f.getGitHubLogin().equals(favorite.getGitHubLogin())
                    && f.getId().equals(favorite.getId()));

    // verify insert is called exactly once
    verify(favoriteRepository).insert((Favorite) anyObject());
    verifyNoMoreInteractions(favoriteRepository);
  }
}