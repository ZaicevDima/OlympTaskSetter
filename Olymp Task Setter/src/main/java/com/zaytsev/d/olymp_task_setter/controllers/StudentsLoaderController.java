package com.zaytsev.d.olymp_task_setter.controllers;

import com.zaytsev.d.olymp_task_setter.models.Activity;
import com.zaytsev.d.olymp_task_setter.models.Students;
//import com.zaytsev.d.olymp_task_setter.repo.StudentsRepository;
import com.zaytsev.d.olymp_task_setter.repo.ActivityRepository;
import com.zaytsev.d.olymp_task_setter.repo.GradesRepository;
import com.zaytsev.d.olymp_task_setter.repo.StudentsRepository;
import com.zaytsev.d.olymp_task_setter.repo.TeachersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

@Controller
public class StudentsLoaderController {
    Logger logger = LoggerFactory.getLogger(StudentsLoaderController.class);
    @Autowired
    private StudentsRepository studentsRepository;
    @Autowired
    private GradesRepository gradesRepository;
    @Autowired
    private TeachersRepository teachersRepository;
    @Autowired
    private ActivityRepository activityRepository;

    @GetMapping("/load")
    public String setUser(@RequestParam("activityId") long activityId, Model model) {
        Optional<Activity> optionalActivity = activityRepository.findById(activityId);
        if (optionalActivity.isPresent()) {
            Activity activity = optionalActivity.get();

            Iterable<Students> studentsIterable = studentsRepository.findAll();

            List<String> studentsNames = new ArrayList<>();
            List<String> taskNumbers = IntStream.rangeClosed(1, activity.getAmountTasks()).boxed().map(Object::toString).toList();


            for (Students student : studentsIterable) {
                List<String> users = Arrays.asList(student.getSurname(), student.getName(), student.getPatronymic());
                studentsNames.add(String.join(" ", users));
            }

            model.addAttribute("studentsOption", studentsNames);
            model.addAttribute("tasksOption", taskNumbers);
            return "Load";
        } else {
            return "redirect:main";
        }
    }

    @PostMapping("/load")
    public String user(@RequestParam("activityId") long activityId, Model model) {
        Optional<Activity> optionalActivity = activityRepository.findById(activityId);
        if (optionalActivity.isPresent()) {
            Activity activity = optionalActivity.get();

            Iterable<Students> studentsIterable = studentsRepository.findAll();

            List<String> studentsNames = new ArrayList<>();
            List<String> taskNumbers = IntStream.rangeClosed(1, activity.getAmountTasks()).boxed().map(Object::toString).toList();


            for (Students student : studentsIterable) {
                List<String> users = Arrays.asList(student.getSurname(), student.getName(), student.getPatronymic());
                studentsNames.add(String.join(" ", users));
            }

            model.addAttribute("studentsOption", studentsNames);
            model.addAttribute("tasksOption", taskNumbers);
            return "Load";
        } else {
            return "redirect:main";
        }
    }
}
