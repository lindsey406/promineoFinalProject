/**
 * 
 */
package com.promineo.donation_tracker.controller.donor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import com.promineo.donation_tracker.service.DonorService;

@RestController
public class DefaultControllerDeleteDonor implements ControllerDeleteDonor {

  @Autowired
  private DonorService donorService;

  @Override
  public ResponseEntity<String> deleteDonor(int donorId) {
    donorService.deleteDonor(donorId);
    
      return  ResponseEntity.ok("Donor deleted!");
    
  }

}
