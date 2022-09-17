/**
 * 
 */
package com.promineo.donation_tracker.service;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.promineo.donation_tracker.dao.DonorDao;
import com.promineo.donation_tracker.entity.Donor;
import com.promineo.donation_tracker.entity.Project;

@Service

public class DefaultDonorService implements DonorService {

  @Autowired
  private DonorDao donorDao;

  // transactional describes a transaction attribute on an individual method or class, applies as a
  // default; use when you want to make sure the entire method executes (all or nothing) if
  // something interrupts the process

  @Override
  public List<Donor> fetchDonorList() {
    List<Donor> donors = donorDao.fetchDonorList();
    return donors;
  }

  @Override
  public Optional<Donor> fetchDonor(int donorId) {
    return donorDao.fetchDonor(donorId);
  }

  @Transactional
  @Override
  public Optional<Donor> createDonor(String donorName, String contactFirst, String contactLast,
      String email) {
    return donorDao.createDonor(donorName, contactFirst, contactLast, email);
  }

  @Transactional
  @Override
  public Optional<Donor> updateDonor(int donorId, String donorName, String contactFirst,
      String contactLast, String email) {

    return donorDao.updateDonor(donorId, donorName, contactFirst, contactLast, email);
  }

  @Transactional
  @Override
  public void deleteDonor(int donorId) {
     donorDao.deleteDonor(donorId);

  }

  @Override
  public List<Project> fetchDonorInterestList(int donorId) {
    return donorDao.fetchDonorInterestList(donorId);
  }
}
