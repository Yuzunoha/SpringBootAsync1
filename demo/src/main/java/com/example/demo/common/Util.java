package com.example.demo.common;

import org.springframework.stereotype.Component;

@Component
public class Util {

  public String getClassMethod(Object o) {
    String[] a = o.getClass().getName().split("\\.");
    String className = a[a.length - 1].split("\\$")[0];
    String methodName = o.getClass().getEnclosingMethod().getName();
    return className + "." + methodName + "()";
  }
}
