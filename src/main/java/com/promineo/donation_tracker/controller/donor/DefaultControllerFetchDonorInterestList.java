/**
 * 
 */
package com.promineo.donation_tracker.controller.donor;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineo.donation_tracker.entity.Donor;
import com.promineo.donation_tracker.entity.Project;
import com.promineo.donation_tracker.service.DonorService;
@RestController

public class DefaultControllerFetchDonorInterestList implements ControllerFetchDonorInterestList {

  @Autowired
  private DonorService donorService;

  public List<Project> fetchDonorInterestList(int donorId) {
    return donorService.fetchDonorInterestList(donorId);
  }
}
