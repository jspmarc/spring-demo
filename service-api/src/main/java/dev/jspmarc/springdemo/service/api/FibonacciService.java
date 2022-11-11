package dev.jspmarc.springdemo.service.api;

import io.reactivex.Single;

public interface FibonacciService {

  Single<Long> computeSequence(int n);

  Single<Long> computeSequenceUsingMemoization(int n);
}
