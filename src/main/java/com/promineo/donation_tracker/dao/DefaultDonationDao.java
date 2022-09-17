/**
 * 
 */
package com.promineo.donation_tracker.dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import com.promineo.donation_tracker.entity.Donation;

@Component

public class DefaultDonationDao implements DonationDao {
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

  @Override
  public Optional<Donation> createDonation(BigDecimal amount, Date receivedDate, int donorId,
      String notes) {

    String insertSql = "INSERT INTO donations (amount, received_date, donor_id, notes) "
        + "VALUES (:amount, :received_date, :donor_id, :notes)";

    // you never send pk (autoincrement) so the database gives you back the id it generated and it
    // goes in keyholder
    KeyHolder keyHolder = new GeneratedKeyHolder();
    SqlParameterSource params = new MapSqlParameterSource().addValue("amount", amount)
        .addValue("received_date", receivedDate).addValue("donor_id", donorId)
        .addValue("notes", notes);

    // jdbcTemplate.update is where the record is created
    jdbcTemplate.update(insertSql, params, keyHolder);

    // load the created donor from the database
    // int id = keyHolder.getKey().intValue();
    return //@formatter:off
       Optional.of(Donation.builder()
        .id(keyHolder.getKey().intValue())
        .amount(amount)
        .receivedDate(receivedDate)
        .donorId(donorId)
        .notes(notes)
        .build());
       // @formatter:on // 
  }


  @Override
  public List<Donation> fetchDonationsByDonorId(int donorId) {
  //@formatter:off  
    String sql =
        "SELECT * "
        + "FROM donations "
        + "WHERE donor_id = :donor_id";
  //@formatter:on  
    SqlParameterSource params = new MapSqlParameterSource().addValue("donor_id", donorId);
    return jdbcTemplate.query(sql, params, new RowMapper<>() {

      @Override
      public Donation mapRow(ResultSet rs, int rowNum) throws SQLException {
        //@formatter:off
            return Donation.builder()
            .id(rs.getInt("id"))
            .amount(rs.getBigDecimal("amount"))
            .receivedDate(rs.getDate("received_date"))
            .donorId(rs.getInt("donor_id"))
            .notes(rs.getString("notes"))
            .build();
           // @formatter:on
      }
    });
  }
}
