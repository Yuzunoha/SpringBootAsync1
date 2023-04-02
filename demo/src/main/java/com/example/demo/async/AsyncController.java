package com.example.demo.async;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AsyncController {

  private final IAsyncService anno1Wrap1;
  private final IAsyncService anno0Wrap1;
  private final IAsyncService anno1Wrap0;
  private final IAsyncService anno0Wrap0;

  @RequestMapping("/")
  public String all() {
    var s = "";
    s += process(anno1Wrap1);
    s += process(anno0Wrap1);
    s += process(anno1Wrap0);
    s += process(anno0Wrap0);
    return s;
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
    s += lapseMs(startMs) + "ms" + "\n\n";
    return s;
  }

  private long lapseMs(long startMs) {
    return System.currentTimeMillis() - startMs;
  }
}
