/**
 * 
 */
package com.promineo.donation_tracker.controller.project;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineo.donation_tracker.entity.Project;
import com.promineo.donation_tracker.service.ProjectService;

@RestController
public class DefaultControllerFetchProjectList implements ControllerFetchProjectList {

  @Autowired
  private ProjectService projectService;

  @Override
  public List<Project> fetchProjectList() {
    return projectService.fetchProjectList();
  }

}
