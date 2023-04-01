package com.example.demo.service;

import java.util.concurrent.CompletableFuture;
import org.springframework.stereotype.Service;

@Service
public class AsyncService4 implements IAsyncService {

  public CompletableFuture<String> method1() {
    try {
      Thread.sleep(100);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return CompletableFuture.completedFuture("method1です。");
  }

  public CompletableFuture<String> method2() {
    try {
      Thread.sleep(100);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return CompletableFuture.completedFuture("method2です。");
  }

  public CompletableFuture<String> method3() {
    try {
      Thread.sleep(100);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return CompletableFuture.completedFuture("method3です。");
  }
}
