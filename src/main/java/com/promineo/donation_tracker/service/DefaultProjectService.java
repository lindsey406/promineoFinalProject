/**
 * 
 */
package com.promineo.donation_tracker.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.promineo.donation_tracker.dao.ProjectDao;
import com.promineo.donation_tracker.entity.Project;

@Service
public class DefaultProjectService implements ProjectService {

@Autowired
ProjectDao projectDao;
  
  @Transactional
  @Override
  public Optional<Project> createProject(String projectName) {
    return projectDao.createProject(projectName);
  }

  @Override
  public Optional<Project> fetchProjectById(int id) {
    return projectDao.fetchProjectById(id);
  }

  @Override
  public List<Project> fetchProjectList() {
    return projectDao.fetchProjectList();
  }

  
}
