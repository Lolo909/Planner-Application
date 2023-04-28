package com.example.retakeexam13042023.web;

import com.example.retakeexam13042023.model.binding.TaskAddBindingModel;
import com.example.retakeexam13042023.model.service.TaskAddServiceModel;
import com.example.retakeexam13042023.service.TaskService;
import com.example.retakeexam13042023.utl.CurrentUser;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;

    public TaskController(TaskService taskService, ModelMapper modelMapper, CurrentUser currentUser) {
        this.taskService = taskService;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }


    @GetMapping("/add")
    public String add() {
        if(currentUser.getId() == null){
            return "redirect:/login";
        }
        return "task-add";
    }

    @ModelAttribute
    public TaskAddBindingModel productAddBindingModel(){
        return new TaskAddBindingModel();
    }

    @PostMapping("/add")
    public String assConform(@Valid TaskAddBindingModel taskAddBindingModel, BindingResult bindingResult
            , RedirectAttributes redirectAttributes) {

        if(bindingResult.hasErrors()){
            redirectAttributes
                    .addFlashAttribute("taskAddBindingModel", taskAddBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.taskAddBindingModel", bindingResult);

            return "redirect:add";
        }

        taskService.addItem(modelMapper.map(taskAddBindingModel, TaskAddServiceModel.class));
        return "redirect:/";
    }


    @GetMapping("/remove/{id}")
    public String remove(@PathVariable Long id) {
        taskService.remove(id);
        return "redirect:/";
    }

    @GetMapping("/return/{id}")
    public String returnTask(@PathVariable Long id) {
        taskService.returnTaskMethod(id);
        return "redirect:/";
    }


    @GetMapping("/addtoMine/{id}")
    public String addToMine(@PathVariable Long id) {
        taskService.addToMine(id);
        return "redirect:/";
    }
}
