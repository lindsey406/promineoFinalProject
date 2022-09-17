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
public class DefaultControllerCreateDonation implements ControllerCreateDonation {

  @Autowired
  DonationService donationService;
  
  @Override
  public Optional<Donation> createDonation(BigDecimal amount, Date receivedDate, int donorId,
      String notes) {
    return donationService.createDonation(amount, receivedDate, donorId, notes);
  }

}
