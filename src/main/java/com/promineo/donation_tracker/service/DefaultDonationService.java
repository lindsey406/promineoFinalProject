/**
 * 
 */
package com.promineo.donation_tracker.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.promineo.donation_tracker.dao.DonationDao;
import com.promineo.donation_tracker.entity.Donation;
import com.promineo.donation_tracker.entity.Donor;

@Service

public class DefaultDonationService implements DonationService {

  @Autowired
  DonationDao donationDao;

  @Transactional
  @Override
  public Optional<Donation> createDonation(BigDecimal amount, Date receivedDate, int donorId,
      String notes) {
    return donationDao.createDonation(amount, receivedDate, donorId, notes);
  }

  @Override
  public List<Donation> fetchDonationsByDonorId(int donorId) {
    return donationDao.fetchDonationsByDonorId(donorId);
  }

}
