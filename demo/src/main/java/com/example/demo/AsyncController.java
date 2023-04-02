package com.example.demo;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AsyncController {

  private final IAsyncService anno1Wrap1;
  private final IAsyncService anno0Wrap1;
  private final IAsyncService anno1Wrap0;
  private final IAsyncService anno0Wrap0;

  @RequestMapping("/")
  public String all() {
    var s = "";
    s += process(anno1Wrap1);
    s += process(anno0Wrap1);
    s += process(anno1Wrap0);
    s += process(anno0Wrap0);
    return s;
  }

  private String process(IAsyncService service) {
    var startMs = System.currentTimeMillis();
    var cf1 = service.method1();
    var cf2 = service.method2();
    var cf3 = service.method3();
    var s = "";
    s += cf1.join() + "\n";
    s += cf2.join() + "\n";
    s += cf3.join() + "\n";
    s += lapseMs(startMs) + "ms" + "\n\n";
    return s;
  }

  private long lapseMs(long startMs) {
    return System.currentTimeMillis() - startMs;
  }
}

interface IAsyncService {
  CompletableFuture<String> method1();
  CompletableFuture<String> method2();
  CompletableFuture<String> method3();
}

@Component
class Common {

  public String getClassMethod(Object o) {
    String[] a = o.getClass().getName().split("\\.");
    String className = a[a.length - 1].split("\\$")[0];
    String methodName = o.getClass().getEnclosingMethod().getName();
    return className + "." + methodName + "()";
  }

  public Supplier<String> sleepSupplier(String s) {
    return () -> {
      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {}
      return s;
    };
  }

  public String sleepProcess(String s) {
    try {
      Thread.sleep(100);
    } catch (InterruptedException e) {}
    return s;
  }
}

@Service
@RequiredArgsConstructor
class Anno0Wrap0 implements IAsyncService {

  private final Common common;

  public CompletableFuture<String> method1() {
    final String s = common.getClassMethod(new Object() {});
    return CompletableFuture.completedFuture(common.sleepProcess(s));
  }

  public CompletableFuture<String> method2() {
    final String s = common.getClassMethod(new Object() {});
    return CompletableFuture.completedFuture(common.sleepProcess(s));
  }

  public CompletableFuture<String> method3() {
    final String s = common.getClassMethod(new Object() {});
    return CompletableFuture.completedFuture(common.sleepProcess(s));
  }
}

@Service
@RequiredArgsConstructor
class Anno0Wrap1 implements IAsyncService {

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

@Service
@RequiredArgsConstructor
class Anno1Wrap0 implements IAsyncService {

  private final Common common;

  @Async
  public CompletableFuture<String> method1() {
    final String s = common.getClassMethod(new Object() {});
    return CompletableFuture.completedFuture(common.sleepProcess(s));
  }

  @Async
  public CompletableFuture<String> method2() {
    final String s = common.getClassMethod(new Object() {});
    return CompletableFuture.completedFuture(common.sleepProcess(s));
  }

  @Async
  public CompletableFuture<String> method3() {
    final String s = common.getClassMethod(new Object() {});
    return CompletableFuture.completedFuture(common.sleepProcess(s));
  }
}

@Service
@RequiredArgsConstructor
class Anno1Wrap1 implements IAsyncService {

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
