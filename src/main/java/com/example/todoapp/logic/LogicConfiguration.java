package com.example.todoapp.logic;

import com.example.todoapp.TaskConfigurationProperties;
import com.example.todoapp.mod.ProjectRepository;
import com.example.todoapp.mod.TaskGroupRepository;
import com.example.todoapp.mod.TaskRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogicConfiguration {

    @Bean
    ProjectService projectService (
            final ProjectRepository repository,
            final TaskGroupRepository taskGroupRepository,
            final TaskGroupService taskGroupService,
            final TaskConfigurationProperties config
            )
            {
                return new ProjectService(repository, taskGroupRepository, config, taskGroupService);
            }

    @Bean
    TaskGroupService taskGroupService (
            final TaskGroupRepository taskGroupRepository,
            final TaskRepository taskRepository
            )
            {
                return  new TaskGroupService(taskGroupRepository, taskRepository);
            }
}
