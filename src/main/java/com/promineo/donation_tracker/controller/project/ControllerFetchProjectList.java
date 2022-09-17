/**
 * 
 */
package com.promineo.donation_tracker.controller.project;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineo.donation_tracker.entity.Project;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@Validated
@RequestMapping("/fetchProjectList")
public interface ControllerFetchProjectList {

//@formatter:off
  @Operation(
    summary = "Returns a list of projects",
    description = "Returns a list of projects",
    responses = {

        @ApiResponse(
            responseCode = "200", 
            description = "A list of projects is returned.", 
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
      })
      //@formatter:on 

  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
  List<Project> fetchProjectList();

}
