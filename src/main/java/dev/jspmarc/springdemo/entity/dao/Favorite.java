package dev.jspmarc.springdemo.entity.dao;

import dev.jspmarc.springdemo.dao.common.BaseMongo;
import dev.jspmarc.springdemo.entity.constant.CollectionName;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import net.karneim.pojobuilder.GeneratePojoBuilder;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = CollectionName.FAVORITE)
@GeneratePojoBuilder
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Favorite extends BaseMongo {

  private int gitHubId;
  private String gitHubLogin;

  @Builder
  public Favorite(String id, Long version, Date createdDate, String createdBy, Date updatedDate,
      String updatedBy, Integer isDeleted, int gitHubId, String gitHubLogin) {
    super(id, version, createdDate, createdBy, updatedDate, updatedBy, isDeleted);
    this.gitHubId = gitHubId;
    this.gitHubLogin = gitHubLogin;
  }
}
