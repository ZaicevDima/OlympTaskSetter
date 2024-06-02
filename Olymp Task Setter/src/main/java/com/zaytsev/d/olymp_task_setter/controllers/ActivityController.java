package com.zaytsev.d.olymp_task_setter.controllers;

import com.zaytsev.d.olymp_task_setter.models.Activity;
//import com.zaytsev.d.olymp_task_setter.repo.StudentsRepository;
import com.zaytsev.d.olymp_task_setter.repo.ActivityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ActivityController {
    Logger logger = LoggerFactory.getLogger(ActivityController.class);

    @Autowired
    private ActivityRepository activityRepository;

    @GetMapping("/activity")
    public String setActivity(Model model) {
        Iterable<Activity> activityIterable = activityRepository.findAll();

        //Set<String> classes = new HashSet<>();
        List<String> activityNames = new ArrayList<>();
        activityIterable.forEach(tempActivity -> activityNames.add(tempActivity.getActivityName()));

        logger.warn(activityNames.toString());
        model.addAttribute("activityOption", activityNames);
        return "Activity";
    }


    @GetMapping("/activity/create")
    public String setActivityCreate(Model model) {
        Iterable<Activity> activityIterable = activityRepository.findAll();

        //Set<String> classes = new HashSet<>();
        List<String> activityNames = new ArrayList<>();
        activityIterable.forEach(tempActivity -> activityNames.add(tempActivity.getActivityName()));

        logger.warn(activityNames.toString());
        model.addAttribute("activityOption", activityNames);
        return "ActivityCreate";
    }


    @GetMapping("/activity/settings")
    public String setActivitySettings(Model model) {
        Iterable<Activity> activityIterable = activityRepository.findAll();

        //Set<String> classes = new HashSet<>();
        List<String> activityNames = new ArrayList<>();
        activityIterable.forEach(tempActivity -> activityNames.add(tempActivity.getActivityName()));

        logger.warn(activityNames.toString());
        model.addAttribute("activityOption", activityNames);
        return "Activity";
    }


    @PostMapping("/activity")
    public String postActivity(@RequestParam String activities, Model model) {
        Iterable<Activity> activityIterable = activityRepository.findAll();
        List<String> activityNames = new ArrayList<>();
        activityIterable.forEach(tempActivity -> activityNames.add(tempActivity.getActivityName()));
        logger.warn("OK!!!!!");
        for (Activity activity : activityIterable) {
            logger.warn(activity.getActivityName());
            if (activity.getActivityName().equals(activities)) {
                logger.warn("Redirect!!!!!!!!");
                return "redirect:/load?activityId=" + activity.getId();
            }
        }

        return "Activity";
    }

    @PostMapping("/activity/create")
    public String postActivityCreate(@RequestParam("activityURL") String activityURL, @RequestParam("activityName") String activityName, Model model) {
        /*Iterable<Activity> activityIterable = activityRepository.findAll();
        List<String> activityNames = new ArrayList<>();
        activityIterable.forEach(tempActivity -> activityNames.add(tempActivity.getActivityName()));
        logger.warn("OK!!!!!");
        for (Activity activity : activityIterable) {
            logger.warn(activity.getActivityName());
            if (activity.getActivityName().equals(activities)) {
                logger.warn("Redirect!!!!!!!!");
                return "redirect:/load?activityId=" + activity.getId();
            }
        }*/
        return "redirect:/activity";
    }

    @PostMapping("/activity/settings")
    public String postActivitySettings(@RequestParam String activities, Model model) {
        Iterable<Activity> activityIterable = activityRepository.findAll();
        List<String> activityNames = new ArrayList<>();
        activityIterable.forEach(tempActivity -> activityNames.add(tempActivity.getActivityName()));
        logger.warn("OK!!!!!");
        for (Activity activity : activityIterable) {
            logger.warn(activity.getActivityName());
            if (activity.getActivityName().equals(activities)) {
                logger.warn("Redirect!!!!!!!!");
                return "redirect:/load?activityId=" + activity.getId();
            }
        }

        return "Activity";
    }
}
