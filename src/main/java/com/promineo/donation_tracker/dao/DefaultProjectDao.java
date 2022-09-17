/**
 * 
 */
package com.promineo.donation_tracker.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import com.promineo.donation_tracker.entity.Donor;
import com.promineo.donation_tracker.entity.Project;

@Component
public class DefaultProjectDao implements ProjectDao {

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

  @Override
  public Optional<Project> fetchProjectById(int id) {

  //@formatter:off  
    String insertSql =
        "SELECT * "
        + "FROM projects "
        + "WHERE project_id = :project_id";
  //@formatter:on  

    Map<String, Object> params = new HashMap<>();
    params.put("project_id", id);

    return Optional
        .ofNullable(jdbcTemplate.query(insertSql, params, new ResultSetExtractor<Project>() {

          @Override
          public Project extractData(ResultSet rs) throws SQLException, DataAccessException {
            if (rs.next()) {
        //@formatter:off
        return Project.builder()
        .id(rs.getInt("project_id"))
        .projectName(rs.getString("project_name"))
        .build();
       // @formatter:on
            } else
              return null;
          }
        }));

  }

  @Override
  public Optional<Project> createProject(String projectName) {

    String insertSql = "INSERT INTO projects (project_name) " + "VALUES (:project_name)";
    // you never send pk (autoincrement) so the database gives you back the id it generated and it
    // goes in keyholder

    KeyHolder keyHolder = new GeneratedKeyHolder();
    SqlParameterSource params = new MapSqlParameterSource().addValue("project_name", projectName);

    // jdbcTemplate.update is where the record is created
    jdbcTemplate.update(insertSql, params, keyHolder);

    // load the created donor from the database
    return //@formatter:off
        Optional.of(Project.builder()
         .id(keyHolder.getKey().intValue())
         .projectName(projectName)
         .build());
  
}

  @Override
  public List<Project> fetchProjectList() {

      String sql =   
          "SELECT * "
          + "FROM projects ";
   
      return jdbcTemplate.query(sql, new RowMapper<>() {

        @Override
        public Project mapRow(ResultSet rs, int rowNum) throws SQLException {
          //@formatter:off
              return Project.builder()
              .id(rs.getInt("project_id"))
              .projectName(rs.getString("project_name"))
              .build();
             // @formatter:on
      }
    });
  }
}
