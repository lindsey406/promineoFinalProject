/**
 * 
 */
package com.promineo.donation_tracker.controller.donor;

import java.util.Optional;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

@RequestMapping("/updateDonor")

public interface ControllerUpdateDonor {

  //@formatter:off
    @Operation(
      summary = "Updates a donor record",
      description = "Updates a donor record given donor id",
      responses = {

          @ApiResponse(
              responseCode = "201", 
              description = "The donor record has been updated.", 
              content = @Content(mediaType = "application/json", 
              schema = @Schema(implementation = Donor.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "Donor record not found.", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "The donor record cannot be updated with the input criteria.", 
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
                 description = "The donor id (i.e., 47)"), 
     
         @Parameter(
                 name = "donorName", 
                 allowEmptyValue = false, 
                 required = false, 
                 description = "The donor name (i.e., 'Patrick Construction')"),
             
         @Parameter(
                 name = "contactFirst", 
                 allowEmptyValue = false, 
                 required = false, 
                     description = "The contact's first name (i.e., 'Tom')"),
                 
         @Parameter(
                 name = "contactLast", 
                 allowEmptyValue = false, 
                 required = false, 
                 description = "The contact's last name (i.e., 'Patrick')"),
                    
         @Parameter(
                 name = "email", 
                 allowEmptyValue = false, 
                 required = false, 
                 description = "The contact's email address (i.e., tpconstruction@gmail.com  )")
             
      } 
        )
        //@formatter:on 

  @PutMapping
  @ResponseStatus(code = HttpStatus.OK)
  Optional<Donor> updateDonor(@RequestParam int donorId, @RequestParam String donorName,
      @RequestParam String contactFirst, @RequestParam String contactLast,
      @RequestParam String email);



}
