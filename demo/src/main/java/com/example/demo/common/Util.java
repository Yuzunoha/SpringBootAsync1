package com.example.demo.common;

import org.springframework.stereotype.Component;

@Component
public class Util {

  public String getClassMethod(Object o) {
    var s = "";
    s += o.getClass().getName() + "\n";
    s += o.getClass().getEnclosingMethod().getName() + "\n";
    return s;
  }
}
