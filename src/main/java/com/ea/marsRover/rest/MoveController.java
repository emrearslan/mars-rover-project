package com.ea.marsRover.rest;

import com.ea.marsRover.nasa.domain.Position;
import com.ea.marsRover.nasa.domain.Rover;
import com.ea.marsRover.nasa.rover.RoverService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/marsRover")
@RestController
@Api(value = "moveController")
public class MoveController {

    @Autowired
    private RoverService roverService;

    @PostMapping(value = "/move", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "Move Mars Rover", response = Iterable.class)
    ResponseEntity<Position> position(@RequestBody Rover rover) {
        Position output = roverService.explore(rover);
        return new ResponseEntity<>(output, HttpStatus.OK);
    }

    @PostMapping(value = "/moves", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "Move Mars Rover", response = Iterable.class)
    ResponseEntity<List<Position>> position(@RequestBody List<Rover> rovers) {
        List<Position> output = roverService.explores(rovers);
        return new ResponseEntity<>(output, HttpStatus.OK);
    }
}
