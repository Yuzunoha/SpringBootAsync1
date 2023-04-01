package com.example.demo.service;

import java.util.concurrent.CompletableFuture;
import org.springframework.stereotype.Service;

@Service
public class AsyncService2 {

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
