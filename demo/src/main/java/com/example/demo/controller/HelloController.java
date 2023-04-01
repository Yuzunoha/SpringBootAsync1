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
  private final IAsyncService asyncService3;
  private final IAsyncService asyncService4;

  @RequestMapping("/hello1")
  public String hello1() {
    return handle(asyncService1);
  }

  @RequestMapping("/hello2")
  public String hello2() {
    return handle(asyncService2);
  }

  @RequestMapping("/hello3")
  public String hello3() {
    return handle(asyncService3);
  }

  @RequestMapping("/hello4")
  public String hello4() {
    return handle(asyncService4);
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
}
