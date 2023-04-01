package com.example.demo.controller;

import com.example.demo.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HelloController {

  private final IAsyncService asyncService1;
  private final IAsyncService asyncService2;

  @RequestMapping("/hello1")
  public String hello1() {
    IAsyncService service = asyncService1;
    long startMs = System.currentTimeMillis();

    String s = "";

    var a = service.method1();
    var b = service.method2();
    var c = service.method3();

    s += a.join() + "\n";
    s += b.join() + "\n";
    s += c.join() + "\n";

    long lapseMs = System.currentTimeMillis() - startMs;

    s += lapseMs + "ms経過\n";

    return s;
  }

  @RequestMapping("/hello2")
  public String hello2() {
    IAsyncService service = asyncService2;
    long startMs = System.currentTimeMillis();

    String s = "";

    var a = service.method1();
    var b = service.method2();
    var c = service.method3();

    s += a.join() + "\n";
    s += b.join() + "\n";
    s += c.join() + "\n";

    long lapseMs = System.currentTimeMillis() - startMs;

    s += lapseMs + "ms経過\n";

    return s;
  }

  private String handle() {
    return "";
  }
}
