/**
 * 
 */
package com.promineo.donation_tracker.controller.donor;

import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import com.promineo.donation_tracker.entity.Donor;
import com.promineo.donation_tracker.service.DonorService;

@RestController
public class DefaultControllerCreateDonor implements ControllerCreateDonor {

  @Autowired
  private DonorService donorService;

  @Override
  public Optional<Donor> createDonor(String donorName, String contactFirst, String contactLast,
      String email) {
   return donorService.createDonor(donorName, contactFirst, contactLast, email);
  }
}
