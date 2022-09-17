/**
 * 
 */
package com.promineo.donation_tracker.dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.promineo.donation_tracker.entity.Donor;
import com.promineo.donation_tracker.entity.Project;

@Component

public class DefaultDonorDao implements DonorDao {

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

  @Override
  public List<Donor> fetchDonorList() {

  //@formatter:off  
    String sql =   
        "SELECT * "
        + "FROM donors ";
  //@formatter:on  

    return jdbcTemplate.query(sql, new RowMapper<>() {

      @Override
      public Donor mapRow(ResultSet rs, int rowNum) throws SQLException {
        //@formatter:off
            return Donor.builder()
            .donorId(rs.getInt("donor_id"))
            .donorName(rs.getString("donor_name"))
            .contactFirst(rs.getString("contact_first"))
            .contactLast(rs.getString("contact_last"))
            .email(rs.getString("email"))
            .build();
           // @formatter:on
      }
    });
  }

  @Override
  public Optional<Donor> fetchDonor(int donorId) {

  //@formatter:off  
    String insertSql =
        "SELECT * "
        + "FROM donors "
        + "WHERE donor_id = :donor_id";
  //@formatter:on  

    Map<String, Object> params = new HashMap<>();
    params.put("donor_id", donorId);

    return Optional
        .ofNullable(jdbcTemplate.query(insertSql, params, new ResultSetExtractor<Donor>() {

          @Override
          public Donor extractData(ResultSet rs) throws SQLException, DataAccessException {
            if (rs.next()) {
        //@formatter:off
        return Donor.builder()
        .donorId(rs.getInt("donor_id"))
        .donorName(rs.getString("donor_name"))
        .contactFirst(rs.getString("contact_first"))
        .contactLast(rs.getString("contact_last"))
        .email(rs.getString("email"))
        .build();
       // @formatter:on
            } else
              return null;
          }
        }));

  }

  @Override
  public Optional<Donor> createDonor(String donorName, String contactFirst, String contactLast,
      String email) {

    String insertSql = "INSERT INTO donors (donor_name, contact_first, contact_last, email) "
        + "VALUES (:donor_name, :contact_first, :contact_last, :email)";
    // you never send pk (autoincrement) so the database gives you back the id it generated and it
    // goes in keyholder

    KeyHolder keyHolder = new GeneratedKeyHolder();
    SqlParameterSource params = new MapSqlParameterSource().addValue("donor_name", donorName)
        .addValue("contact_first", contactFirst).addValue("contact_last", contactLast)
        .addValue("email", email);

    // jdbcTemplate.update is where the record is created
    jdbcTemplate.update(insertSql, params, keyHolder);

    // load the created donor from the database
    int id = keyHolder.getKey().intValue();
    return fetchDonor(id);
  }

  @Override
  public Optional<Donor> updateDonor(int donorId, String donorName, String contactFirst,
      String contactLast, String email) {
  //@formatter:off  
    String updateSql =   //"" next line +
        "UPDATE donors "
        + "SET donor_name = :donor_name, contact_first = :contact_first, contact_last = :contact_last, email = :email " 
        + "WHERE id = :id";
  //@formatter:on  

    SqlParameterSource params = new MapSqlParameterSource().addValue("donor_id", donorId)
        .addValue("donor_name", donorName).addValue("contact_first", contactFirst)
        .addValue("contact_last", contactLast).addValue("email", email);
    jdbcTemplate.update(updateSql, params);

    return fetchDonor(donorId);
  }

  @Override
  public void deleteDonor(int donorId) {
    String sql = "DELETE FROM donors WHERE donor_id = :donor_id";
    SqlParameterSource params = new MapSqlParameterSource().addValue("donor_id", donorId);
    jdbcTemplate.update(sql, params);
  }

  @Override
  public List<Project> fetchDonorInterestList(int donorId) {

    String sql =
        "SELECT projects.project_id, project_name "
        + "FROM donor_project, donors, projects "
        + "WHERE donor_project.project_id = projects.project_id "
        + "AND donor_project.donor_id = donors.donor_id "
        + "AND donors.donor_id = :donors.donor_id";
    

    SqlParameterSource params = new MapSqlParameterSource().addValue("donors.donor_id", donorId);
    return jdbcTemplate.query(sql, params, new RowMapper<>() {

      @Override
      public Project mapRow(ResultSet rs, int rowNum) throws SQLException {
        //@formatter:off
            return Project.builder()
            .id(rs.getInt("projects.project_id"))
            .projectName(rs.getString("projects.project_name"))
            .build();
           // @formatter:on
      }
    });
  }
}



// return Optional.of(new Donor("Bennett Consulting", "Lindsey", "Bennett",
// "lindsbrandt@gmail.com"));
// // have to return Optional.of because return type is Optional above
// // return Optional.empty();
// // where you're actually using the database
