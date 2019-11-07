package com.ea.marsRover;

import com.ea.marsRover.application.MarsRoverApplication;
import com.ea.marsRover.nasa.domain.*;
import com.ea.marsRover.nasa.domain.builder.CoordinateBuilder;
import com.ea.marsRover.nasa.domain.builder.PositionBuilder;
import com.ea.marsRover.nasa.domain.builder.RoverBuilder;
import com.ea.marsRover.nasa.rover.RoverService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@SpringBootTest(classes = MarsRoverApplication.class)
class MarsRoverApplicationTests {

    @Autowired
    private RoverService roverService;

    private Rover rover1;
    private Rover rover2;
    private List<Rover> rovers;

    @BeforeEach
    void setUp() {
        Coordinate plateau1 = new CoordinateBuilder().x(5).y(5).doBuild();
        Coordinate coordinate1 = new CoordinateBuilder().x(1).y(2).doBuild();
        Direction direction1 = new Compass.North();
        Position position1 = new PositionBuilder().coordinate(coordinate1).direction(direction1).doBuild();

        List<Command> commands1 = Arrays.asList(Command.L, Command.M, Command.L,
                Command.M, Command.L, Command.M, Command.L, Command.M, Command.M);

        rover1 = new RoverBuilder().plateau(plateau1).position(position1).commands(commands1).doBuild();

        Coordinate plateau2 = new CoordinateBuilder().x(5).y(5).doBuild();
        Coordinate coordinate2 = new CoordinateBuilder().x(3).y(3).doBuild();
        Direction direction2 = new Compass.East();
        Position position2 = new PositionBuilder().coordinate(coordinate2).direction(direction2).doBuild();

        List<Command> commands2 = Arrays.asList(Command.M, Command.M, Command.R,
                Command.M, Command.M, Command.R, Command.M, Command.R, Command.R, Command.M);

        rover2 = new RoverBuilder().plateau(plateau2).position(position2).commands(commands2).doBuild();

        rovers = Arrays.asList(rover1, rover2);
    }

    /**
     * Test input:
     * 1 2 N
     * LMLMLMLMM
     * <p>
     * Test Output:
     * 1 3 N
     */
    @Test
    public void testCase01() {
        Position explore = roverService.explore(rover1);

        Assertions.assertAll("MarsRover move change fail",
                () -> Assertions.assertEquals(explore.getCoordinate().getX(), 1),
                () -> Assertions.assertEquals(explore.getCoordinate().getY(), 3),
                () -> Assertions.assertEquals(explore.getDirection(), new Compass.North()));
    }

    /**
     * Test input:
     * 3 3 E
     * MMRMMRMRRM
     * <p>
     * Test Output:
     * 5 1 E
     */
    @Test
    public void testCase02() {
        Position explore = roverService.explore(rover2);

        Assertions.assertAll("MarsRover move change fail",
                () -> Assertions.assertEquals(explore.getCoordinate().getX(), 5),
                () -> Assertions.assertEquals(explore.getCoordinate().getY(), 1),
                () -> Assertions.assertEquals(explore.getDirection(), new Compass.East()));
    }

}
