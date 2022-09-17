/**
 * 
 */
package com.promineo.donation_tracker.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Project {
  private Integer id;
  private String projectName;

  // all args but pk
  public Project(String projectName) {}



}
