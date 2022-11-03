package dev.jspmarc.springdemo.rest.web.model.request;

import com.tiket.tix.common.entity.CommonModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@AllArgsConstructor
@Builder
public class FavoriteRequest extends CommonModel {
  private static final long serialVersionUID = 1L;
  private String gitHubLogin;
  private int gitHubId;
}
