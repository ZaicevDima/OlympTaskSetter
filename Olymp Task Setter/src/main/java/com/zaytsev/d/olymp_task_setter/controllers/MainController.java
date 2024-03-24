package com.zaytsev.d.olymp_task_setter.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String hello() {
        return "Hello";
    }
}
