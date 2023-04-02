package com.example.demo.async;

import java.util.concurrent.CompletableFuture;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Anno1Wrap1 implements IAsyncService {

  private final Common common;

  @Async
  public CompletableFuture<String> method1() {
    final String s = common.getClassMethod(new Object() {});
    return CompletableFuture.supplyAsync(common.sleepSupplier(s));
  }

  @Async
  public CompletableFuture<String> method2() {
    final String s = common.getClassMethod(new Object() {});
    return CompletableFuture.supplyAsync(common.sleepSupplier(s));
  }

  @Async
  public CompletableFuture<String> method3() {
    final String s = common.getClassMethod(new Object() {});
    return CompletableFuture.supplyAsync(common.sleepSupplier(s));
  }
}
