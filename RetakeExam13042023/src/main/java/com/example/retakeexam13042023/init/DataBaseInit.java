package com.example.retakeexam13042023.init;

import com.example.retakeexam13042023.service.PriorityService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataBaseInit implements CommandLineRunner {

        private final PriorityService priorityService;

        public DataBaseInit(PriorityService priorityService) {
            this.priorityService = priorityService;
        }

        @Override
        public void run(String... args) throws Exception {
            priorityService.initCategories();
        }
}
