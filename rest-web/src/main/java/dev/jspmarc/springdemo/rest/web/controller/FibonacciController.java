package dev.jspmarc.springdemo.rest.web.controller;

import dev.jspmarc.springdemo.service.api.FibonacciService;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

@RestController
@RequestMapping("/fibonacci")
@Slf4j
public class FibonacciController {

  FibonacciService fibonacciService;

  Scheduler fibonacciScheduler;

  @Autowired
  public FibonacciController(FibonacciService fibonacciService, Scheduler fibonacciScheduler) {
    this.fibonacciService = fibonacciService;
    this.fibonacciScheduler = fibonacciScheduler;
  }

  @GetMapping
  public DeferredResult<Long> fibonacci(@RequestParam int n, @RequestParam boolean memoization) {
    log.info("Got req - n : " + n + " - memoization : " + memoization);
    Single<Long> single = null;
    DeferredResult<Long> result = new DeferredResult<>();
    if (memoization) {
      single = fibonacciService.computeSequenceUsingMemoization(n);
    } else {
      single = fibonacciService.computeSequence(n);
    }
    single.subscribeOn(fibonacciScheduler).subscribe(result::setResult, result::setErrorResult);

    return result;
  }
}
