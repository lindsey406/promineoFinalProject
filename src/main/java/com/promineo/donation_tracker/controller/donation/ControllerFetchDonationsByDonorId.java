/**
 * 
 */
package com.promineo.donation_tracker.controller.donation;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineo.donation_tracker.entity.Donation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RequestMapping("/fetchDonationsByDonorId")
public interface ControllerFetchDonationsByDonorId {

//@formatter:off
  @Operation(
    summary = "Retrieves a list of donations",
    description = "Retrieves a list of donations given a donor id",
    responses = {

        @ApiResponse(
            responseCode = "201", 
            description = "A donation list has been created.", 
            content = @Content(mediaType = "application/json", 
            schema = @Schema(implementation = Donation.class))),
        @ApiResponse(
            responseCode = "400", 
            description = "The input parameters are invalid.", 
            content = @Content(mediaType = "application/json")),
        @ApiResponse(
            responseCode = "404", 
            description = "A donation list cannot be created with the input criteria.", 
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
           description = "The donor id (i.e., 5)")
    })
      //@formatter:on 
    
  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
  List<Donation> fetchDonationsByDonorId(@RequestParam int donorId);

}
