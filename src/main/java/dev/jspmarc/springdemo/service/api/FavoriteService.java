package dev.jspmarc.springdemo.service.api;

import dev.jspmarc.springdemo.rest.web.model.request.FavoriteRequest;
import dev.jspmarc.springdemo.rest.web.model.response.FavoriteResponse;
import io.reactivex.Single;

import java.util.List;

public interface FavoriteService {
    Single<List<FavoriteResponse>> getAll();

    Single<FavoriteResponse> addToFavorite(FavoriteRequest favoriteRequest);
}
