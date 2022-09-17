/**
 * 
 */
package com.promineo.donation_tracker.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import com.promineo.donation_tracker.entity.Donor;
import com.promineo.donation_tracker.entity.Project;

public interface DonorService {

  /**
   * @return list of donors from database
   */
  List<Donor> fetchDonorList();

  /**
   * @param donorId
   * @return
   */
  Optional<Donor> fetchDonor(int donorId);

  /**
   * @param donorName
   * @param contactFirst
   * @param contactLast
   * @param email
   * @return
   */
  public Optional<Donor> createDonor(String donorName, String contactFirst, String contactLast,
      String email);

  /**
   * @return
   */
  Optional<Donor> updateDonor(int donorId, String donorName, String contactFirst,
      String contactLast, String email);

  /**
   * @param donorId
   * @throws SQLException
   */
  void deleteDonor(int donorId);

  /**
   * @return
   */
  List<Project> fetchDonorInterestList(int donorId);

}
