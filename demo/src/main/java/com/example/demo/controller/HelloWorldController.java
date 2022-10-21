package com.example.demo.controller;

import com.example.demo.model.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/hello-world")
public class HelloWorldController {

  @GetMapping("/")
  public Message helloWorld() {
    Message message = new Message("Hello world");
    return message;
  }

  @GetMapping("/name")
  public Message helloWorldName(@RequestParam String name) {
    Message message = new Message("Hello world " + name);
    return message;
  }
}
