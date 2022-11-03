package dev.jspmarc.springdemo.entity.constant;

import lombok.Getter;

@Getter
public enum ResponseCode {
  SUCCESS("SUCCESS", "SUCCESS");

  private final String code;
  private final String message;

  ResponseCode(String code, String message) {
    this.code = code;
    this.message = message;
  }
}
