package com.ea.marsRover.nasa.domain.builder;

import com.ea.marsRover.nasa.domain.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest(classes = RoverBuilder.class)
public class RoverBuilderTest {

    private Rover rover;

    private Coordinate plateau;
    private Coordinate coordinate;
    private Direction direction;
    private Position position;
    private List<Command> commands;


    @BeforeEach
    void setUp() {
        plateau = new CoordinateBuilder().x(5).y(5).doBuild();
        coordinate = new CoordinateBuilder().x(1).y(2).doBuild();
        direction = new Compass.North();
        position = new PositionBuilder().coordinate(coordinate).direction(direction).doBuild();

        commands = Arrays.asList(Command.L, Command.M, Command.L,
                Command.M, Command.L, Command.M, Command.L, Command.M, Command.M);
    }

    @Test
    public void shouldRoverBuilder() {
        Rover rover = new RoverBuilder().plateau(plateau).position(position).commands(commands).doBuild();

        Assertions.assertAll("RoverBuilder fail",
                () -> Assertions.assertEquals(rover.getPosition(), position),
                () -> Assertions.assertEquals(rover.getCommands(), commands),
                () -> Assertions.assertEquals(rover.getPlateau(), plateau));
    }

    @Test
    public void shouldRoverBuilderWithOneCommand() {
        Command command = Command.M;
        Rover rover = new RoverBuilder().plateau(plateau).position(position).command(command).doBuild();

        Assertions.assertAll("RoverBuilder fail",
                () -> Assertions.assertEquals(rover.getPosition(), position),
                () -> Assertions.assertEquals(rover.getCommands().get(0), command),
                () -> Assertions.assertEquals(rover.getPlateau(), plateau));
    }

}