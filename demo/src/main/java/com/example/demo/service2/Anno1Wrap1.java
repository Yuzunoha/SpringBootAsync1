package com.example.demo.service2;

import java.util.concurrent.CompletableFuture;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class Anno1Wrap1 implements IAsyncService {

  @Async
  public CompletableFuture<String> method1() {
    return CompletableFuture.supplyAsync(() -> {
      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {}
      return "method1";
    });
  }

  @Override
  public CompletableFuture<String> method2() {
    throw new UnsupportedOperationException("Unimplemented method 'method2'");
  }

  @Override
  public CompletableFuture<String> method3() {
    throw new UnsupportedOperationException("Unimplemented method 'method3'");
  }
}
