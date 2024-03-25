package com.zaytsev.d.olymp_task_setter.controllers;

import com.zaytsev.d.olymp_task_setter.models.Students;
import com.zaytsev.d.olymp_task_setter.repo.StudentsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    Logger logger = LoggerFactory.getLogger(MainController.class);
    @Autowired
    private StudentsRepository studentsRepository;

    @GetMapping("/test")
    public String hello(Model model) {
        Iterable<Students> students = studentsRepository.findAll();
        model.addAttribute("students", students);
        return "Main";
    }

    @GetMapping("/put")
    public String put(Model model) {
        return "Hello";
    }

    @PostMapping("/put")
    public String putInfo(@RequestParam String username, @RequestParam String usermark,  Model model) {
        logger.warn(username);
        logger.warn(usermark);
        Students students = new Students(username, Integer.parseInt(usermark));
        studentsRepository.save(students);
        return "redirect:/test";
    }
}
