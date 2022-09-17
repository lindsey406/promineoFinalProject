/**
 * 
 */
package com.promineo.donation_tracker.controller.donor;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;



@Validated
@RequestMapping("/deleteDonor")

public interface ControllerDeleteDonor {

  //@formatter:off
  @Operation(
    summary = "Deletes a donor record",
    description = "Deletes a donor record given a donor id",
    responses = {

        @ApiResponse(
            responseCode = "200", 
            description = "A donor record has been deleted.", 
            content = @Content(mediaType = "text/html")), 
       
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
           description = "The donor id (i.e., 12)")
    } 
      )
      //@formatter:on 

  @DeleteMapping
  ResponseEntity<String> deleteDonor(@RequestParam int donorId);

}
