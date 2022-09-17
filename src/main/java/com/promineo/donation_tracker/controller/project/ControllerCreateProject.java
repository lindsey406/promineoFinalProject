package com.promineo.donation_tracker.controller.project;

import java.util.Optional;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineo.donation_tracker.entity.Donor;
import com.promineo.donation_tracker.entity.Project;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping("/createProject")

public interface ControllerCreateProject {

  //@formatter:off
  @Operation(
    summary = "Creates a project",
    description = "Creates a project",
    responses = {

        @ApiResponse(
            responseCode = "201", 
            description = "A project has been created.", 
            content = @Content(mediaType = "application/json", 
            schema = @Schema(implementation = Project.class))),
        @ApiResponse(
            responseCode = "400", 
            description = "The input parameters are invalid.", 
            content = @Content(mediaType = "application/json")),
        @ApiResponse(
            responseCode = "404", 
            description = "A project cannot be created with the input criteria.", 
            content = @Content(mediaType = "application/json")),
        @ApiResponse(
            responseCode = "500", 
            description = "An unplanned error occurred.", 
            content = @Content(mediaType = "application/json"))
    },
    parameters = {
       @Parameter(
           name = "projectName", 
           allowEmptyValue = false, 
           required = false, 
           description = "The project name (i.e., 'Rotary Canyon Trail')"),
    } 
      )
      //@formatter:on 

  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
  Optional<Project> createProject(@Valid @RequestParam String projectName);
 
}
