package dev.jspmarc.springdemo.service.impl;

import dev.jspmarc.springdemo.service.api.FibonacciService;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import java.util.ArrayList;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class FibonacciServiceImpl implements FibonacciService {

  Scheduler fibonacciScheduler;

  @Autowired
  FibonacciServiceImpl(Scheduler fibonacciScheduler) {
    this.fibonacciScheduler = fibonacciScheduler;
  }

  @Override
  public Single<Long> computeSequence(int n) {
    return Single.defer(() -> {
      if (n >= 23) {
        log.info("Got req (NO memoization): " + n);
      }

      if (n == 0 || n == 1) {
        return Single.just(1L);
      }

      Single<Long> left = computeSequence(n - 1);
      Single<Long> right = computeSequence(n - 2);

      return Single.zip(left, right, Long::sum);
    });
  }

  @Override
  public Single<Long> computeSequenceUsingMemoization(int n) {
    return Single.fromCallable(() -> {
      log.info("Got req (WITH memoization): " + n);
      if (n == 0 || n == 1) {
        return 1L;
      }

      ArrayList<Long> memo = new ArrayList<>(Arrays.asList(1L, 1L));

      for (int i = 2; i <= n; ++i) {
        Long sum = memo.get(i - 1) + memo.get(i - 2);
        memo.add(sum);
      }

      return memo.get(n);
    });
  }
}
