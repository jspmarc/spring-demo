package dev.jspmarc.springdemo.libraries.configuration.scheduler;

public class SchedulerConfiguration {
  private Integer maxThread;
  private Integer minIdleThread;
  private Integer threadTtl;
  private Integer maxQueue;

  public Integer getMaxThread() {
    return maxThread;
  }

  public void setMaxThread(Integer maxThread) {
    this.maxThread = maxThread;
  }

  public Integer getMinIdleThread() {
    return minIdleThread;
  }

  public void setMinIdleThread(Integer minIdleThread) {
    this.minIdleThread = minIdleThread;
  }

  public Integer getThreadTtl() {
    return threadTtl;
  }

  public void setThreadTtl(Integer threadTtl) {
    this.threadTtl = threadTtl;
  }

  public Integer getMaxQueue() {
    return maxQueue;
  }

  public void setMaxQueue(Integer maxQueue) {
    this.maxQueue = maxQueue;
  }
}
