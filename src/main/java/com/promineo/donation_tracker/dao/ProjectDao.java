/**
 * 
 */
package com.promineo.donation_tracker.dao;

import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import com.promineo.donation_tracker.entity.Project;

public interface ProjectDao {

  /**
   * @param projectName
   * @return
   */
  Optional<Project> createProject(String projectName);

  /**
   * @param projectId
   * @return
   */
  Optional<Project> fetchProjectById(int id);

  /**
   * @return
   */
  List<Project> fetchProjectList();

}
