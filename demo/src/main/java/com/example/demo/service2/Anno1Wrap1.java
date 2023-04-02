package com.example.demo.service2;

import com.example.demo.common.Util;
import java.util.concurrent.CompletableFuture;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Anno1Wrap1 implements IAsyncService {

  private final Util util;

  @Async
  public CompletableFuture<String> method1() {
    var o = new Object() {};
    final String t = util.getClassMethod(o);
    return CompletableFuture.supplyAsync(() -> {
      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {}
      return t;
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
