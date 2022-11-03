package dev.jspmarc.springdemo.rest.web.model.response;

import com.tiket.tix.common.entity.CommonModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import net.karneim.pojobuilder.GeneratePojoBuilder;

@GeneratePojoBuilder
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@Builder
public class FavoriteResponse extends CommonModel {
  private String id;
  private int gitHubId;
  private String gitHubLogin;
}
