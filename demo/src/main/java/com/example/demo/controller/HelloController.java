package com.example.demo.controller;

import com.example.demo.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HelloController {

  private final AsyncService1 asyncService1;
  private final AsyncService2 asyncService2;

  @RequestMapping("/hello")
  public String hello() {
    AsyncService2 service = asyncService2;
    long startMs = System.currentTimeMillis();

    String s = "";

    s += service.method1().join() + "\n";
    s += service.method2().join() + "\n";
    s += service.method3().join() + "\n";

    long lapseMs = System.currentTimeMillis() - startMs;

    s += lapseMs + "ms経過\n";

    return s;
  }
}
