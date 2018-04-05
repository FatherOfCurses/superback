package com.lmig.ci.superhero.superherosightings.controllers;

import com.lmig.ci.superhero.superherosightings.domain.Power;
import com.lmig.ci.superhero.superherosightings.service.DatabaseService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import io.swagger.annotations.ApiOperation;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/power")

public class PowerController {

    @Autowired
    private DatabaseService databaseService;


    @ApiOperation(value = "Add a new Power to the Database",
                  response = Power.class,
                  notes="This is a way to add a power to the database")
    @ApiResponses(value = {
            @ApiResponse(code=200, message="Success")
    })
    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Power createPower(@RequestBody Power power) {
        return databaseService.addPower(power);
    }


    @ApiOperation(value = "List all powers in the Database", response = Power.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 404, message = "Power not found")
    })
    @GetMapping(value = "/getall", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Power> listAllPowers() {
        return databaseService.listAllPowers();
    }

    @ApiOperation(value = "Get power by ID", response = Power.class)
    @ApiResponses(value = {
            @ApiResponse(code=200, message="Success"),
            @ApiResponse(code=404, message="Power not found")
    })
    @GetMapping(path = {"/get/{powerId}"})
    // Use ResponseEntity to wrap the returned query in case there is an error
    public ResponseEntity<Power> listPowerById(@PathVariable("powerId") int id) throws Exception {
        return databaseService.getPower(id) == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : ResponseEntity.ok(databaseService.getPower(id));
    }

    @ApiOperation(value = "Update a power", response = Power.class, notes="Will update information for a power when ID is specified or passed from UI", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(code=200, message="Success"),
            @ApiResponse(code=404, message="Power not found")
    })
    @PutMapping(path = {"/update/{powerId}"})
    public ResponseEntity<Power> updatePowerById(@PathVariable("powerId") int id, @RequestBody Power power) throws Exception {
        return databaseService.updatePower(power) == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : ResponseEntity.ok(databaseService.updatePower(power));
    }

    @ApiOperation(value = "Delete a power", notes="Will delete a power from the database when ID is specified or passed from UI", consumes = MediaType.APPLICATION_JSON_VALUE)
    @DeleteMapping(path = {"/delete/{powerId}"})
    public void deletePowerById(@PathVariable("powerId") int id) throws Exception {
        if(returnPower(id) == null) {
            new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            databaseService.deletePower(id);
        new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    }


    private Power returnPower(int powerId) {
        return databaseService.getPower(powerId);
    }
}
