package com.example.demo.controller;

import com.example.demo.service.AsyncService1;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HelloController {

  private final AsyncService1 asyncService1;

  @RequestMapping("/hello")
  public String hello() {
    String s = "";

    s += asyncService1.method1().join();

    return s;
  }
}
