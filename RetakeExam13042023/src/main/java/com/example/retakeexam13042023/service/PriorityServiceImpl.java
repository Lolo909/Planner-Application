package com.example.retakeexam13042023.service;

import com.example.retakeexam13042023.model.entity.Priority;
import com.example.retakeexam13042023.model.entity.enums.PriorityNameEnum;
import com.example.retakeexam13042023.repository.PriorityRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class PriorityServiceImpl implements PriorityService {

    private final PriorityRepository priorityRepository;

    public PriorityServiceImpl(PriorityRepository priorityRepository) {
        this.priorityRepository = priorityRepository;
    }

    @Override
    public void initCategories() {
        if(priorityRepository.count()!=0){
            return;
        }


        Arrays.stream(PriorityNameEnum.values()).forEach(priorityNameEnum -> {
            String descriptionText = "";

            if(priorityNameEnum.equals(PriorityNameEnum.URGENT)){
                descriptionText = "An urgent problem that blocks the system use until the issue is resolved.";
            }else if(priorityNameEnum.equals(PriorityNameEnum.IMPORTANT)){
                descriptionText = "A core functionality that your product is explicitly supposed to perform is compromised";
            }else{
                descriptionText = "Should be fixed if time permits but can be postponed.";
            }

            Priority priority = new Priority(priorityNameEnum, descriptionText);

            priorityRepository.save(priority);
        });
    }

    @Override
    public Priority findByCategoryNameEnum(PriorityNameEnum categoryNameEnum) {
        return priorityRepository.findByName(categoryNameEnum)
                .orElse(null);
    }
}
