package com.zaytsev.d.olymp_task_setter.controllers;

import com.zaytsev.d.olymp_task_setter.models.Students;
import com.zaytsev.d.olymp_task_setter.repo.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @Autowired
    private StudentsRepository studentsRepository;

    @GetMapping("/")
    public String hello(Model model) {
        Iterable<Students> students = studentsRepository.findAll();
        model.addAttribute("students", students);
        return "Hello";
    }
}
