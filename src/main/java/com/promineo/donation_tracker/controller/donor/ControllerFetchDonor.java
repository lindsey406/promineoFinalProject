/**
 * 
 */
package com.promineo.donation_tracker.controller.donor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineo.donation_tracker.entity.Donor;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;


@Validated
@RequestMapping("/fetchDonor")
@OpenAPIDefinition(info = @Info(title = "Fetch Donor"),
    servers = {@Server(url = "http://localhost:8080", description = "Local server.")})

public interface ControllerFetchDonor {

  //@formatter:off
  @Operation(
    summary = "Returns a donor",
    description = "Returns a donor given a donor id",
    responses = {

        @ApiResponse(
            responseCode = "200", 
            description = "A donor name is returned.", 
            content = @Content(mediaType = "application/json", 
            schema = @Schema(implementation = Donor.class))),
        @ApiResponse(
            responseCode = "400", 
            description = "The request parameters are invalid.", 
            content = @Content(mediaType = "application/json")),
        @ApiResponse(
            responseCode = "404", 
            description = "No donors were found with the input criteria.", 
            content = @Content(mediaType = "application/json")),
        @ApiResponse(
            responseCode = "500", 
            description = "An unplanned error occurred.", 
            content = @Content(mediaType = "application/json"))
    },
    parameters = {
       @Parameter(
           name = "donorId", 
           allowEmptyValue = false, 
           required = false, 
           description = "The donor id (i.e., 1)")
    } 
      )
      //@formatter:on 

  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
  ResponseEntity<Donor> fetchDonor(@RequestParam int donorId);


}

