package dev.jspmarc.springdemo.rest.web.controller;

import com.tiket.tix.common.rest.web.model.response.BaseResponse;
import com.tiket.tix.common.rest.web.model.response.CommonResponse;
import com.tiket.tix.hotel.common.model.enums.ResponseCode;
import dev.jspmarc.springdemo.entity.constant.ApiPath;
import dev.jspmarc.springdemo.rest.web.model.request.FavoriteRequest;
import dev.jspmarc.springdemo.rest.web.model.response.FavoriteResponse;
import dev.jspmarc.springdemo.service.api.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.List;

@RestController
@RequestMapping(ApiPath.BASE_FAVORITE_PATH)
public class FavoriteController {

  private final FavoriteService favoriteService;

  @Autowired
  public FavoriteController(FavoriteService favoriteService) {
    this.favoriteService = favoriteService;
  }

  @GetMapping
  public DeferredResult<BaseResponse<List<FavoriteResponse>>> getFavorites() {
    DeferredResult<BaseResponse<List<FavoriteResponse>>> result = new DeferredResult<>();
    favoriteService
            .getAll()
            .map(favorites -> CommonResponse.constructResponse(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage(), null, favorites))
            .subscribe(result::setResult, result::setErrorResult);
    return result;
  }

  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
  public DeferredResult<BaseResponse<FavoriteResponse>> favoritesUser(@RequestBody FavoriteRequest req) {
    DeferredResult<BaseResponse<FavoriteResponse>> result = new DeferredResult<>();
    favoriteService
            .addToFavorite(req)
            .map(f -> CommonResponse.constructResponse(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage(), null, f))
            .subscribe(result::setResult, result::setErrorResult);
    return result;
  }
}
