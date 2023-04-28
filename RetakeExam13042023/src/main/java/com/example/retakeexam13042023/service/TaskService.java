package com.example.retakeexam13042023.service;

import com.example.retakeexam13042023.model.service.TaskAddServiceModel;
import com.example.retakeexam13042023.model.view.TaskViewModel;

import java.util.List;

public interface TaskService {
    void addItem(TaskAddServiceModel map);


    int findNumberOfAllTasksWhichAreNotMine(Long id);

    List<TaskViewModel> AllTasksWhichAreNotMine(Long id);

    List<TaskViewModel>  allMyTasks(Long id);

    void remove(Long id);

    void returnTaskMethod(Long id);

    void addToMine(Long id);
}
