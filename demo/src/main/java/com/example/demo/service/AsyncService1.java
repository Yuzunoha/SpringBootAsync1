package com.example.demo.service;

import java.util.concurrent.CompletableFuture;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncService1 {

  @Async
  public CompletableFuture<String> method1() {
    return CompletableFuture.completedFuture("method1です。");
  }
}
