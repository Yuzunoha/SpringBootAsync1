package com.example.demo.async;

import java.util.concurrent.CompletableFuture;

public interface IAsyncService {
  CompletableFuture<String> method1();
  CompletableFuture<String> method2();
  CompletableFuture<String> method3();
}
