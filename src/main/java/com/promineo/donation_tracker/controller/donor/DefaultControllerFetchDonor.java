/**
 * 
 */
package com.promineo.donation_tracker.controller.donor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import com.promineo.donation_tracker.entity.Donor;
import com.promineo.donation_tracker.service.DonorService;

@RestController
public class DefaultControllerFetchDonor implements ControllerFetchDonor {

  @Autowired
  private DonorService donorService;

  @Override
  public ResponseEntity<Donor> fetchDonor(int donorId) {
    return ResponseEntity.of(donorService.fetchDonor(donorId));

  }
}
