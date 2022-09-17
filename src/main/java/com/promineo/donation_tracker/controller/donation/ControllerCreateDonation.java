/**
 * 
 */
package com.promineo.donation_tracker.controller.donation;

import java.math.BigDecimal;
import org.springframework.web.bind.annotation.RequestMapping;
import io.swagger.v3.oas.annotations.Operation;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineo.donation_tracker.entity.Donation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;


@RequestMapping("/createDonation")

public interface ControllerCreateDonation {

  //@formatter:off
    @Operation(
      summary = "Creates a donation",
      description = "Creates a donation",
      responses = {

          @ApiResponse(
              responseCode = "201", 
              description = "A donation has been created.", 
              content = @Content(mediaType = "application/json", 
              schema = @Schema(implementation = Donation.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The input parameters are invalid.", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "A donation cannot be created with the input criteria.", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500", 
              description = "An unplanned error occurred.", 
              content = @Content(mediaType = "application/json"))
      },
      parameters = {
         @Parameter(
             name = "amount", 
             allowEmptyValue = false, 
             required = false, 
             description = "The donation amount (i.e., 700.00)"),
         
         @Parameter(
             name = "receivedDate", 
             allowEmptyValue = false, 
             required = false, 
                 description = "Received date of donation (i.e., MM-DD-YYYY)"),
             
         @Parameter(
             name = "donorId", 
             allowEmptyValue = false, 
             required = false, 
             description = "The donor id (i.e., 5)"),
                
         @Parameter(
             name = "notes", 
             allowEmptyValue = false, 
             required = false, 
             description = "Notes about the donation")
      } 
        )
        //@formatter:on 

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
   Optional<Donation> createDonation(@RequestParam BigDecimal amount, @RequestParam @DateTimeFormat(pattern = "MM-dd-yyyy")Date receivedDate,
        @RequestParam int donorId, 
        @RequestParam String notes);
    
}

