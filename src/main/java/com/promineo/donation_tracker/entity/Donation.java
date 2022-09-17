/**
 * 
 */
package com.promineo.donation_tracker.entity;

import java.math.BigDecimal;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Donation {

  private Integer id;
  private BigDecimal amount;
  private Date receivedDate;
  // private Donor donor;
  private int donorId;
  private String notes;


  // constructor all args but PK
  public Donation(BigDecimal amount, Date receivedDate, int donorId, String notes) {}


}

