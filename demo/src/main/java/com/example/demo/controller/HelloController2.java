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

  @RequestMapping("/1")
  public String hello1() {
    return "HelloController2/1";
  }
}
