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

  @RequestMapping("/1/1")
  public String hello1_1() {
    var startMs = System.currentTimeMillis();

    var s = "";
    s += anno1Wrap1.method1().join() + "\n";
    s += anno1Wrap1.method2().join() + "\n";
    s += anno1Wrap1.method3().join() + "\n";

    s += lapseMs(startMs) + "ms" + "\n";
    return s;
  }

  @RequestMapping("/1/2")
  public String hello1_2() {
    var startMs = System.currentTimeMillis();

    var s = "";
    var cf1 = anno1Wrap1.method1();
    var cf2 = anno1Wrap1.method2();
    var cf3 = anno1Wrap1.method3();
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
