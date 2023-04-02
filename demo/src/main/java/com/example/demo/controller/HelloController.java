package com.example.demo.controller;

import com.example.demo.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/hello1")
public class HelloController {

  private final IAsyncService asyncService1;
  private final IAsyncService asyncService2;
  private final IAsyncService asyncService3;
  private final IAsyncService asyncService4;
  private final IStringService stringService1;
  private final IStringService stringService2;

  @RequestMapping("/1")
  public String hello1() {
    return handle(asyncService1);
  }

  @RequestMapping("/2")
  public String hello2() {
    return handle(asyncService2);
  }

  @RequestMapping("/3")
  public String hello3() {
    return handle(asyncService3);
  }

  @RequestMapping("/4")
  public String hello4() {
    return handle(asyncService4);
  }

  @RequestMapping("/5")
  public String hello5() {
    return handle(stringService1);
  }

  @RequestMapping("/6")
  public String hello6() {
    return handle(stringService2);
  }

  private String handle(IAsyncService service) {
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

  private String handle(IStringService service) {
    long startMs = System.currentTimeMillis();

    String s = "";

    var a = service.method1();
    var b = service.method2();
    var c = service.method3();

    s += a + "\n";
    s += b + "\n";
    s += c + "\n";

    long lapseMs = System.currentTimeMillis() - startMs;

    s += lapseMs + "ms経過\n";

    return s;
  }
}
