package dev.jspmarc.springdemo.service.impl;

import dev.jspmarc.springdemo.dao.api.FavoriteRepository;
import dev.jspmarc.springdemo.entity.dao.Favorite;
import dev.jspmarc.springdemo.entity.dao.FavoriteBuilder;
import dev.jspmarc.springdemo.rest.web.model.request.FavoriteRequest;
import dev.jspmarc.springdemo.service.api.FavoriteService;
import io.reactivex.Single;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteServiceImpl implements FavoriteService {
    private final FavoriteRepository favoriteRepository;

    @Autowired
    public FavoriteServiceImpl(FavoriteRepository favoriteRepository) {
        this.favoriteRepository = favoriteRepository;
    }

    @Override
    public Single<List<Favorite>> getAll() {
        return Single.just(favoriteRepository.findAll());
    }

    @Override
    public Single<Favorite> addToFavorite(FavoriteRequest favoriteRequest) {
        return Single.just(favoriteRepository.insert(
                new FavoriteBuilder()
                        .withGitHubId(favoriteRequest.getGitHubId())
                        .withGitHubLogin(favoriteRequest.getGitHubLogin())
                        .build()
        ));
    }
}
