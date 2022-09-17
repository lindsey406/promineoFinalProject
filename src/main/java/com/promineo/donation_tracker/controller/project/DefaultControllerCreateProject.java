/**
 * 
 */
package com.promineo.donation_tracker.controller.project;

import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineo.donation_tracker.entity.Project;
import com.promineo.donation_tracker.service.ProjectService;

@RestController
public class DefaultControllerCreateProject implements ControllerCreateProject{

  
  @Autowired
  ProjectService projectService;
  
  @Override
  public Optional<Project> createProject(@Valid String projectName) {
    return projectService.createProject(projectName);
  }

}
