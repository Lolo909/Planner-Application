package com.example.retakeexam13042023.service;

import com.example.retakeexam13042023.model.entity.Task;
import com.example.retakeexam13042023.model.entity.User;
import com.example.retakeexam13042023.model.service.TaskAddServiceModel;
import com.example.retakeexam13042023.model.view.TaskViewModel;
import com.example.retakeexam13042023.repository.TaskRepository;
import com.example.retakeexam13042023.repository.UserRepository;
import com.example.retakeexam13042023.utl.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {


    private final TaskRepository taskRepository;
    private final ModelMapper modelMapper;
    private final PriorityService priorityService;
    private final UserService userService;
    private final CurrentUser currentUser;
    private final UserRepository userRepository;

    public TaskServiceImpl(TaskRepository taskRepository, ModelMapper modelMapper, PriorityService priorityService, UserService userService, CurrentUser currentUser, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.modelMapper = modelMapper;
        this.priorityService = priorityService;
        this.userService = userService;
        this.currentUser = currentUser;

        this.userRepository = userRepository;
    }

    @Override
    public void addItem(TaskAddServiceModel taskAddServiceModel) {
        Task task = modelMapper.map(taskAddServiceModel, Task.class);
        task.setUser(userService.findById(currentUser.getId()));
        task.setPriority(priorityService.findByCategoryNameEnum(taskAddServiceModel.getPriority()));
        //product.setGender(productAddServiceModel.getGender());

        taskRepository.save(task);
    }

    @Override
    public int findNumberOfAllTasksWhichAreNotMine(Long id) {
        return taskRepository.findAllByUserId(null)
                .stream()
                .map(task -> {
                    TaskViewModel taskViewModel = modelMapper.map(task, TaskViewModel.class);
                    taskViewModel.setPriority(task.getPriority().getName());
                        return taskViewModel;



                }).collect(Collectors.toList()).size();
    }

    @Override
    public List<TaskViewModel> AllTasksWhichAreNotMine(Long id) {
        return taskRepository.findAllByUserId(null)
                .stream()
                .map(task -> {
                    TaskViewModel taskViewModel  = modelMapper.map(task, TaskViewModel.class);
                    taskViewModel.setPriority(task.getPriority().getName());
                        return taskViewModel;

                }).collect(Collectors.toList());
    }

    @Override
    public List<TaskViewModel> allMyTasks(Long id) {
        return taskRepository.findAllByUserId(id)
                .stream()
                .map(task -> {
                    TaskViewModel taskViewModel  = modelMapper.map(task, TaskViewModel.class);
                    taskViewModel.setPriority(task.getPriority().getName());
                    return taskViewModel;

                }).collect(Collectors.toList());
    }

    @Override
    public void remove(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public void returnTaskMethod(Long id) {
        Task task = taskRepository.findById(id).orElse(null);
        task.setUser(null);
        taskRepository.deleteById(id);
        taskRepository.save(task);
    }

    @Override
    public void addToMine(Long id) {
        Task task = taskRepository.findById(id).orElse(null);
        User user = userRepository.findById(currentUser.getId()).orElse(null);
        task.setUser(user);
        taskRepository.deleteById(id);
        taskRepository.save(task);
    }
}
