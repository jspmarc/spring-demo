package dev.jspmarc.springdemo.dao.api;

import dev.jspmarc.springdemo.entity.dao.Favorite;
import org.springframework.data.domain.Page;

public interface FavoriteRepositoryCustom {
    Page<Favorite> findAllPageable();
}
