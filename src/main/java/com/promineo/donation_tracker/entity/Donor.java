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

public class Donor {

  private int donorId;
  private String donorName;
  private String contactFirst;
  private String contactLast;
  private String email;
  // private List<Donation> donationList;

  // all args but pk
  public Donor(String donorName, String contactFirst, String contactLast, String email) {}

  
}
