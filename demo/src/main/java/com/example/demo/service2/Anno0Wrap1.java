package com.example.demo.service2;

import com.example.demo.common.Util;
import java.util.concurrent.CompletableFuture;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Anno0Wrap1 implements IAsyncService {

  private final Util util;

  public CompletableFuture<String> method1() {
    final String s = util.getClassMethod(new Object() {});
    return CompletableFuture.supplyAsync(util.sleepSupplier(s));
  }

  public CompletableFuture<String> method2() {
    final String s = util.getClassMethod(new Object() {});
    return CompletableFuture.supplyAsync(util.sleepSupplier(s));
  }

  public CompletableFuture<String> method3() {
    final String s = util.getClassMethod(new Object() {});
    return CompletableFuture.supplyAsync(util.sleepSupplier(s));
  }
}
