package com.example.retakeexam13042023.web;

import com.example.retakeexam13042023.service.TaskService;
import com.example.retakeexam13042023.service.UserService;
import com.example.retakeexam13042023.utl.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    private final CurrentUser currentUser;
    private final TaskService taskService;
    private final UserService userService;

    public HomeController(CurrentUser currentUser, TaskService taskService, UserService userService) {
        this.currentUser = currentUser;
        this.taskService = taskService;
        this.userService = userService;
    }


    @GetMapping("/")
    public ModelAndView index(ModelAndView modelAndView) {

        if (currentUser.getId() == null) {
            modelAndView.setViewName("index");
        } else {

            modelAndView.addObject("numberOfAllAvailableTasks", taskService.findNumberOfAllTasksWhichAreNotMine(currentUser.getId()));
            modelAndView.addObject("AllAvailableTasks", taskService.AllTasksWhichAreNotMine(currentUser.getId()));
            modelAndView.addObject("allMyTasks", taskService.allMyTasks(currentUser.getId()));
            modelAndView.addObject("currentUser", userService.findById(currentUser.getId()));
            //modelAndView.addObject("allItemsPrice", sum);

            modelAndView.setViewName("home");

        }

        return modelAndView;
    }
}
