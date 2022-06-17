package dev.jspmarc.springdemo.dao.api;

import dev.jspmarc.springdemo.entity.dao.Favorite;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FavoriteRepository extends MongoRepository<Favorite, String> {
}
