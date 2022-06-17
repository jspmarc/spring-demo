package dev.jspmarc.springdemo.dao.mongodb;

import dev.jspmarc.springdemo.dao.api.FavoriteRepositoryCustom;
import dev.jspmarc.springdemo.entity.dao.Favorite;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

@Repository
public class FavoriteRepositoryImpl implements FavoriteRepositoryCustom {
    @Override
    public Page<Favorite> findAllPageable() {
        return null;
    }
}
