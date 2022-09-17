/**
 * 
 */
package com.promineo.donation_tracker.controller.donor;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineo.donation_tracker.entity.Donor;
import com.promineo.donation_tracker.service.DonorService;
@RestController

public class DefaultControllerUpdateDonor implements ControllerUpdateDonor {
  @Autowired
  private DonorService donorService;

  @Override
  public Optional<Donor> updateDonor(int donorId, String donorName, String contactFirst, String contactLast, String email) {

    return donorService.updateDonor(donorId, donorName, contactFirst, contactLast, email);
  }


}
