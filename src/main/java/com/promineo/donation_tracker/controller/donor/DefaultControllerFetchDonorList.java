/**
 * 
 */
package com.promineo.donation_tracker.controller.donor;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import com.promineo.donation_tracker.entity.Donor;
import com.promineo.donation_tracker.service.DonorService;

// RestController = This is where my REST endpoints are going to be. Before, when you went to port
// 8080 nothing happened, but now this is a REST application and we can use getmapping

@RestController
public class DefaultControllerFetchDonorList implements ControllerFetchDonorList{

  @Autowired
  private DonorService donorService;

  @Override
  public List<Donor> fetchDonorList() {
    return donorService.fetchDonorList();
  }



  // Optional<Donor> me = donorService.fetchDonor(donorId);
  // if (me.isPresent()) {
  // return new ResponseEntity<>(me.get(), HttpStatus.OK);
  // // return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  // } else
  // throw new DonorNotFoundException("Donor not found.");
}

