/**
 * 
 */
package com.promineo.donation_tracker.controller.donor;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineo.donation_tracker.entity.Donor;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@Validated
@RequestMapping("/fetchDonorList")

public interface ControllerFetchDonorList {

  
  //@formatter:off
  @Operation(
    summary = "Returns a list of donors",
    description = "Returns a list of donors",
    responses = {

        @ApiResponse(
            responseCode = "200", 
            description = "A list of donors is returned.", 
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
      })
      //@formatter:on 

  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
  List<Donor> fetchDonorList();
}
