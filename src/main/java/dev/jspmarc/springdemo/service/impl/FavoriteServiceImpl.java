package dev.jspmarc.springdemo.service.impl;

import dev.jspmarc.springdemo.dao.api.FavoriteRepository;
import dev.jspmarc.springdemo.entity.dao.Favorite;
import dev.jspmarc.springdemo.rest.web.model.request.FavoriteRequest;
import dev.jspmarc.springdemo.rest.web.model.response.FavoriteResponse;
import dev.jspmarc.springdemo.service.api.FavoriteService;
import io.reactivex.Single;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FavoriteServiceImpl implements FavoriteService {

  private final FavoriteRepository favoriteRepository;

  @Autowired
  public FavoriteServiceImpl(FavoriteRepository favoriteRepository) {
    this.favoriteRepository = favoriteRepository;
  }

  @Override
  public Single<List<FavoriteResponse>> getAll() {
    return Single.fromCallable(() ->
        favoriteRepository
            .findAll()
            .stream()
            .map(favorite -> FavoriteResponse.builder()
                .gitHubId(favorite.getGitHubId())
                .gitHubLogin(favorite.getGitHubLogin())
                .id(favorite.getId())
                .build())
            .collect(Collectors.toList()));
  }

  @Override
  public Single<FavoriteResponse> addToFavorite(FavoriteRequest favoriteRequest) {
    return Single.fromCallable(() -> {
      Favorite favorite = favoriteRepository.save(
          Favorite.builder()
              .gitHubId(favoriteRequest.getGitHubId())
              .gitHubLogin(favoriteRequest.getGitHubLogin())
              .build()
      );
      return FavoriteResponse.builder()
          .gitHubId(favorite.getGitHubId())
          .gitHubLogin(favorite.getGitHubLogin())
          .id(favorite.getId())
          .build();
    });
  }
}
