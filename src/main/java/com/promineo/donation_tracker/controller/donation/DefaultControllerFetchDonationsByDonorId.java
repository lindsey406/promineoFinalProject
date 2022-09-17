/**
 * 
 */
package com.promineo.donation_tracker.controller.donation;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineo.donation_tracker.entity.Donation;
import com.promineo.donation_tracker.service.DonationService;
@RestController

public class DefaultControllerFetchDonationsByDonorId
    implements ControllerFetchDonationsByDonorId {

  @Autowired
  DonationService donationService;

  @Override
  public List<Donation> fetchDonationsByDonorId(int donorId) {
    return donationService.fetchDonationsByDonorId(donorId);
  }

}
