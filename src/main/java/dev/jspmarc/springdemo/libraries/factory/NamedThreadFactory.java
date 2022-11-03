package dev.jspmarc.springdemo.libraries.factory;

import java.util.concurrent.ThreadFactory;

public class NamedThreadFactory implements ThreadFactory {

  private int counter = 0;
  private String prefix = "";

  public NamedThreadFactory(String prefix) {
    this.prefix = prefix;
  }

  @Override
  public Thread newThread(Runnable r) {
    return new Thread(r, prefix + "-" + counter++);
  }
}
