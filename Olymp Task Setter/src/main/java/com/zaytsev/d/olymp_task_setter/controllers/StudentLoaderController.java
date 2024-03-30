package com.zaytsev.d.olymp_task_setter.controllers;

import com.zaytsev.d.olymp_task_setter.models.Students;
//import com.zaytsev.d.olymp_task_setter.repo.StudentsRepository;
import com.zaytsev.d.olymp_task_setter.repo.TeachersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Controller
public class StudentLoaderController {
    /*Logger logger = LoggerFactory.getLogger(MainController.class);
    @Autowired
    private StudentsRepository studentRepository;

    @GetMapping("/temp")
    public String mainStudents(@ModelAttribute("tempStudents") Students students, Model model) {
        //Iterable<TempStudents> tempStudents = tempStudentRepository.findAll();
        //logger.warn("__________________");
        //logger.warn(tempStudents.toString());
        Iterable<Students> tempStudentsss = studentRepository.findAll();
        List<String> tempStudentss = Arrays.asList("Дмитрий", "Александр", "Дарья");
        logger.warn("^^^^^^^^^^^^^");
        List<String> student = new ArrayList<>();
        List<String> marks = Arrays.asList("0", "1", "2", "3", "4", "5", "6");
        List<String> tasks = Arrays.asList("1 задача", "2 задача", "3 задача", "4 задача");

        /*for (Students tmp : tempStudentsss) {
            List<String> users = Arrays.asList(tmp.getName(), tmp.getFirstName(), tmp.getSurname());
            student.add(String.join(" ", users));
        }*/
        /*logger.warn(student.toString());
        Collections.sort(student);
        model.addAttribute("options", student);
        model.addAttribute("tasks", tasks);
        model.addAttribute("marks", marks);
        return "Temp";
    }

    @PostMapping("/put")
    public String sendTask(@RequestParam String studentList, @RequestParam String taskList, @RequestParam String markList, Model model) {
        logger.warn("~~~~~~~~~~~~~~~~~~~~~");
        logger.warn(studentList);
        logger.warn(taskList);
        logger.warn(markList);
        String[] userInfo = studentList.split(" ");
        String firstname =  userInfo[2];
        String secondname = userInfo[1];
        String surname =  userInfo[3];

        //Students students = new Students(name, s, surname, );
        //tempStudentRepository
        return "redirect:/test";
    }*/
}
