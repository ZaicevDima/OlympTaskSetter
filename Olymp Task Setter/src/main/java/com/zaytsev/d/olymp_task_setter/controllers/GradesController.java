package com.zaytsev.d.olymp_task_setter.controllers;

import com.zaytsev.d.olymp_task_setter.models.GradesValues;
import com.zaytsev.d.olymp_task_setter.repo.ActivityRepository;
import com.zaytsev.d.olymp_task_setter.repo.GradesValuesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GradesController {
    Logger logger = LoggerFactory.getLogger(ActivityController.class);

    @Autowired
    GradesValuesRepository gradesValuesRepository;
    @Autowired
    ActivityRepository activityRepository;
    @GetMapping("/grades")
    String mainGradesScreen(Model model) {
        return "GradesMain";
    }

    @PostMapping("/grades")
    String mainGradesScreen2(Model model) {
        return "GradesMain";
    }

    /*@PostMapping("/grades")
    String putGradesScreen(@Model model) {
        return "GradesMain";
    }*/
    @GetMapping("/grades/set")
    String setGradesScreen(Model model) {
        var gradesItems = gradesValuesRepository.findAll();
        List<String> gradesValues = new ArrayList<>();

        for (GradesValues grade : gradesItems) {
            gradesValues.add(grade.getGrade());
        }

        logger.warn("!!!!!!!!!!");
        logger.warn(gradesValues.toString());
        model.addAttribute("gradesOption", gradesValues);
        return "GradesSet";
    }
    @PostMapping("/grades/set")
    String addGrade(@RequestParam String grades, Model model) {
        GradesValues value = new GradesValues(grades);
        gradesValuesRepository.save(value);

        var gradesItems = gradesValuesRepository.findAll();
        List<String> gradesValues = new ArrayList<>();

        for (GradesValues grade : gradesItems) {
            gradesValues.add(grade.getGrade());
        }

        logger.warn("!!!!!!!!!!");
        logger.warn(gradesValues.toString());
        model.addAttribute("gradesOption", gradesValues);

        return "GradesSet";
    }

    @PostMapping("/grades/delete")
    String removeGrade(@RequestParam String grades, Model model) {
        GradesValues value = new GradesValues(grades);
        gradesValuesRepository.save(value);

        var gradesItems = gradesValuesRepository.findAll();
        List<String> gradesValues = new ArrayList<>();

        for (GradesValues grade : gradesItems) {
            gradesValues.add(grade.getGrade());
        }

        logger.warn("!!!!!!!!!!");
        logger.warn(gradesValues.toString());
        model.addAttribute("gradesOption", gradesValues);

        return "GradesSet";
    }

    //@PostMapping("/grades/delete")
    //String deleteGradesScreen2(Model model) {
    //    return "GradesDelete";
    //}
}
