package dev.jspmarc.springdemo.libraries.configuration.scheduler;

import com.tiket.tix.currency.libraries.factory.NamingThreadFactory;
import com.tiket.tix.hotel.cart.libraries.configuration.scheduler.SchedulerConfiguration;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Configuration
public class SpringDemoScheduler {

  @Bean
  public Scheduler gitHubScheduler(SchedulerGitHubConfiguration schedulerGitHubConfiguration) {
    return get(schedulerGitHubConfiguration, "GitHub");
  }

  private Scheduler get(SchedulerConfiguration configuration, String prefix) {
    int minIdle =
            configuration.getMinIdleThread() != null ? configuration.getMinIdleThread() : 0;
    int maxThread =
            configuration.getMaxThread() != null ? configuration.getMaxThread() : Integer.MAX_VALUE;
    int ttl = configuration.getThreadTtl() != null ? configuration.getThreadTtl() : 0;
    int maxQueue =
            configuration.getMaxQueue() != null ? configuration.getMaxQueue() : Integer.MAX_VALUE;

    NamingThreadFactory threadFactory = new NamingThreadFactory(prefix);

    return Schedulers.from(new ThreadPoolExecutor(minIdle, maxThread, ttl, TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(maxQueue), threadFactory));
  }
}
