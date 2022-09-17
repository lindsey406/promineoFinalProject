/**
 * 
 */
package com.promineo.donation_tracker.controller.project;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import com.promineo.donation_tracker.entity.Project;
import com.promineo.donation_tracker.service.ProjectService;

@RestController
public class DefaultControllerFetchProjectById implements ControllerFetchProjectById {

  @Autowired
  ProjectService projectService;

  @Override
  public ResponseEntity<Project> fetchProject(int id) {
    return ResponseEntity.of(projectService.fetchProjectById(id));

  }
}
