package com.example.demo.common;

import java.util.function.Supplier;
import org.springframework.stereotype.Component;

@Component
public class Util {

  public String getClassMethod(Object o) {
    String[] a = o.getClass().getName().split("\\.");
    String className = a[a.length - 1].split("\\$")[0];
    String methodName = o.getClass().getEnclosingMethod().getName();
    return className + "." + methodName + "()";
  }

  public Supplier<String> sleepSupplier(String s) {
    return () -> {
      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {}
      return s;
    };
  }
}
