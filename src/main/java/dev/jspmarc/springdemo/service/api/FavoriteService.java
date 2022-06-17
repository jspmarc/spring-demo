package dev.jspmarc.springdemo.service.api;

import dev.jspmarc.springdemo.entity.dao.Favorite;
import dev.jspmarc.springdemo.rest.web.model.request.FavoriteRequest;
import io.reactivex.Single;

import java.util.List;

public interface FavoriteService {
    Single<List<Favorite>> getAll();

    Single<Favorite> addToFavorite(FavoriteRequest favoriteRequest);
}
