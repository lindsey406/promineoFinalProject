/**
 * 
 */
package com.promineo.donation_tracker.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import com.promineo.donation_tracker.entity.Donation;

public interface DonationDao {

  /**
   * @param amount
   * @param receivedDate
   * @param donorId
   * @param notes
   * @return
   */
  Optional<Donation> createDonation(BigDecimal amount, Date receivedDate, int donorId,
      String notes);

  /**
   * @param donorId
   * @return
   */
  List<Donation> fetchDonationsByDonorId(int donorId);

}
