/**
 * 
 */
package com.promineo.donation_tracker.controller.project;

import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineo.donation_tracker.entity.Donor;
import com.promineo.donation_tracker.entity.Project;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@Validated
@RequestMapping("/fetchProjectById")

public interface ControllerFetchProjectById {

//@formatter:off
  @Operation(
    summary = "Returns a project",
    description = "Returns a project name given a project id",
    responses = {

        @ApiResponse(
            responseCode = "200", 
            description = "A project name is returned.", 
            content = @Content(mediaType = "application/json", 
            schema = @Schema(implementation = Project.class))),
        @ApiResponse(
            responseCode = "400", 
            description = "The request parameters are invalid.", 
            content = @Content(mediaType = "application/json")),
        @ApiResponse(
            responseCode = "404", 
            description = "No projects were found with the input criteria.", 
            content = @Content(mediaType = "application/json")),
        @ApiResponse(
            responseCode = "500", 
            description = "An unplanned error occurred.", 
            content = @Content(mediaType = "application/json"))
    },
    parameters = {
       @Parameter(
           name = "id", 
           allowEmptyValue = false, 
           required = false, 
           description = "The project id (i.e., 1)")
    } 
      )
      //@formatter:on 

  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
  ResponseEntity<Project> fetchProject(@RequestParam int id);


}
