package com.example.demo.service;

import java.util.concurrent.CompletableFuture;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Anno0Wrap1 implements IAsyncService {

  private final Common common;

  public CompletableFuture<String> method1() {
    final String s = common.getClassMethod(new Object() {});
    return CompletableFuture.supplyAsync(common.sleepSupplier(s));
  }

  public CompletableFuture<String> method2() {
    final String s = common.getClassMethod(new Object() {});
    return CompletableFuture.supplyAsync(common.sleepSupplier(s));
  }

  public CompletableFuture<String> method3() {
    final String s = common.getClassMethod(new Object() {});
    return CompletableFuture.supplyAsync(common.sleepSupplier(s));
  }
}
