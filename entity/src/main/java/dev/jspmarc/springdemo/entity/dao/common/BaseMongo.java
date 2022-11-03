package dev.jspmarc.springdemo.entity.dao.common;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;

@Data
@EqualsAndHashCode
@ToString
public class BaseMongo {

  private static final long serialVersionUID = 1L;

  @Id
  private String id;

  @Version
  private Long version;

  @CreatedDate
  private Date createdDate;

  private String createdBy = "SYSTEM";

  @LastModifiedDate
  private Date updatedDate;

  private String updatedBy = "SYSTEM";

  private Integer isDeleted = 0;

  public BaseMongo() {
  }

  public BaseMongo(String id, Long version, Date createdDate, String createdBy, Date updatedDate,
      String updatedBy, Integer isDeleted) {
    this.id = id;
    this.version = version;
    this.createdDate = createdDate;
    this.createdBy = createdBy;
    this.updatedDate = updatedDate;
    this.updatedBy = updatedBy;
    this.isDeleted = isDeleted;
  }
}
