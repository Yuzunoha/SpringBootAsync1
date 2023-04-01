package com.example.demo.service;

import java.util.concurrent.CompletableFuture;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncService3 implements IAsyncService {

  @Async
  public CompletableFuture<String> method1() {
    return CompletableFuture.supplyAsync(() -> {
      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      return "method1です。";
    });
  }

  @Async
  public CompletableFuture<String> method2() {
    return CompletableFuture.supplyAsync(() -> {
      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      return "method2です。";
    });
  }

  @Async
  public CompletableFuture<String> method3() {
    return CompletableFuture.supplyAsync(() -> {
      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      return "method3です。";
    });
  }
}
