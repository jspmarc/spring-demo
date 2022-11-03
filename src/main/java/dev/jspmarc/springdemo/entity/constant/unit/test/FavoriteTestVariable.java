package dev.jspmarc.springdemo.entity.constant.unit.test;

import dev.jspmarc.springdemo.entity.constant.GitHubServiceConstant;
import dev.jspmarc.springdemo.entity.dao.Favorite;
import dev.jspmarc.springdemo.rest.web.model.request.FavoriteRequest;
import dev.jspmarc.springdemo.rest.web.model.response.FavoriteResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FavoriteTestVariable implements GitHubServiceConstant {

  private final static Random rand = new Random();

  public static Favorite getFavorite() {
    int id = rand.nextInt(MAX_USER_ID);
    return Favorite.builder()
        .gitHubId(id)
        .gitHubLogin("user" + id)
        .id("sss" + id)
        .build();
  }

  public static FavoriteRequest getFavoriteRequest(int id, String login) {
    return FavoriteRequest.builder()
        .gitHubId(id)
        .gitHubLogin(login)
        .build();
  }

  public static List<Favorite> getFavorites() {
    ArrayList<Favorite> favorites = new ArrayList<>();

    int n = rand.nextInt(10);
    for (int i = 0; i < n; ++i) {
      favorites.add(getFavorite());
    }

    return favorites;
  }


  public static FavoriteResponse getFavoriteResponse() {
    int id = rand.nextInt(MAX_USER_ID);
    return FavoriteResponse.builder()
        .gitHubId(id)
        .gitHubLogin("user" + id)
        .id("sss" + id)
        .build();
  }

  public static List<FavoriteResponse> getFavoriteResponses() {
    ArrayList<FavoriteResponse> favorites = new ArrayList<>();
    int n;
    do {
      n = rand.nextInt(10);
    } while (n <= 0);
    for (int i = 0; i < n; ++i) {
      favorites.add(getFavoriteResponse());
    }

    return favorites;
  }
}
