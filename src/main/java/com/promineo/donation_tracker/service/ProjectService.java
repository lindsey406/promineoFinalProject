/**
 * 
 */
package com.promineo.donation_tracker.service;

import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.promineo.donation_tracker.entity.Project;



public interface ProjectService {

  /**
   * @param projectName
   * @return
   */
  Optional<Project> createProject(String projectName);

  
  Optional<Project> fetchProjectById(int id);


  /**
   * @return
   */
  List<Project> fetchProjectList();
   
}
