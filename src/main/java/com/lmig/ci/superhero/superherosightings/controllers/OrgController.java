package com.lmig.ci.superhero.superherosightings.controllers;

import com.lmig.ci.superhero.superherosightings.domain.Org;
import com.lmig.ci.superhero.superherosightings.service.DatabaseService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/org")

public class OrgController {

    @Autowired
    private DatabaseService databaseService;


    @ApiOperation(value = "Add a new Power to the Database",
            response = Org.class,
            notes = "This is a way to add a power to the database")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success")
    })
    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Org createOrg(@RequestBody Org org) {
        return databaseService.addOrg(org);
    }

}

