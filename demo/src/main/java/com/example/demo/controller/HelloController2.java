package com.example.demo.controller;

import com.example.demo.service2.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/hello2")
public class HelloController2 {

  private final IAsyncService anno1Wrap1;
  private final IAsyncService anno0Wrap1;

  @RequestMapping("/anno1wrap1")
  public String anno1Wrap1() {
    return process(anno1Wrap1);
  }

  @RequestMapping("/anno0wrap1")
  public String anno0Wrap1() {
    return process(anno0Wrap1);
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
    s += lapseMs(startMs) + "ms" + "\n";
    return s;
  }

  private long lapseMs(long startMs) {
    return System.currentTimeMillis() - startMs;
  }
}
