package com.ea.marsRover.nasa.rover;

import com.ea.marsRover.application.MarsRoverApplication;
import com.ea.marsRover.nasa.domain.*;
import com.ea.marsRover.nasa.domain.builder.CoordinateBuilder;
import com.ea.marsRover.nasa.domain.builder.PositionBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = MarsRoverApplication.class)
public class PositionServiceTest {

    @InjectMocks
    private PositionService positionService;

    @Test
    public void shouldChangePositionTurnLeftWhenDirectionEast() {
        Coordinate coordinate = new CoordinateBuilder().x(3).y(3).doBuild();
        Direction direction = new Compass.East();
        Position position = new PositionBuilder().coordinate(coordinate).direction(direction).doBuild();

        Position newPosition = positionService.changePosition(position, Command.L);

        Assertions.assertAll("TurnLeftWhenDirectionEast not changed",
                () -> Assertions.assertEquals(newPosition.getDirection(), new Compass.North()),
                () -> Assertions.assertEquals(newPosition.getCoordinate().getX(), position.getCoordinate().getX()),
                () -> Assertions.assertEquals(newPosition.getCoordinate().getY(), position.getCoordinate().getY()));
    }

    @Test
    public void shouldChangePositionTurnRightWhenDirectionEast() {
        Coordinate coordinate = new CoordinateBuilder().x(3).y(3).doBuild();
        Direction direction = new Compass.East();
        Position position = new PositionBuilder().coordinate(coordinate).direction(direction).doBuild();

        Position newPosition = positionService.changePosition(position, Command.R);

        Assertions.assertAll("TurnRightWhenDirectionEast not changed",
                () -> Assertions.assertEquals(newPosition.getDirection(), new Compass.South()),
                () -> Assertions.assertEquals(newPosition.getCoordinate().getX(), position.getCoordinate().getX()),
                () -> Assertions.assertEquals(newPosition.getCoordinate().getY(), position.getCoordinate().getY()));
    }

    @Test
    public void shouldChangePositionTurnLeftWhenDirectionNorth() {
        Coordinate coordinate = new CoordinateBuilder().x(3).y(3).doBuild();
        Direction direction = new Compass.North();
        Position position = new PositionBuilder().coordinate(coordinate).direction(direction).doBuild();

        Position newPosition = positionService.changePosition(position, Command.L);

        Assertions.assertAll("TurnRightWhenDirectionNorth not changed",
                () -> Assertions.assertEquals(newPosition.getDirection(), new Compass.West()),
                () -> Assertions.assertEquals(newPosition.getCoordinate().getX(), position.getCoordinate().getX()),
                () -> Assertions.assertEquals(newPosition.getCoordinate().getY(), position.getCoordinate().getY()));
    }

    @Test
    public void shouldChangePositionTurnRightWhenDirectionNorth() {
        Coordinate coordinate = new CoordinateBuilder().x(3).y(3).doBuild();
        Direction direction = new Compass.North();
        Position position = new PositionBuilder().coordinate(coordinate).direction(direction).doBuild();

        Position newPosition = positionService.changePosition(position, Command.R);

        Assertions.assertAll("TurnRightWhenDirectionNorth not changed",
                () -> Assertions.assertEquals(newPosition.getDirection(), new Compass.East()),
                () -> Assertions.assertEquals(newPosition.getCoordinate().getX(), position.getCoordinate().getX()),
                () -> Assertions.assertEquals(newPosition.getCoordinate().getY(), position.getCoordinate().getY()));
    }

    @Test
    public void shouldChangePositionTurnLeftWhenDirectionSouth() {
        Coordinate coordinate = new CoordinateBuilder().x(3).y(3).doBuild();
        Direction direction = new Compass.South();
        Position position = new PositionBuilder().coordinate(coordinate).direction(direction).doBuild();

        Position newPosition = positionService.changePosition(position, Command.L);

        Assertions.assertAll("TurnRightWhenDirectionSouth not changed",
                () -> Assertions.assertEquals(newPosition.getDirection(), new Compass.East()),
                () -> Assertions.assertEquals(newPosition.getCoordinate().getX(), position.getCoordinate().getX()),
                () -> Assertions.assertEquals(newPosition.getCoordinate().getY(), position.getCoordinate().getY()));
    }

    @Test
    public void shouldChangePositionTurnRightWhenDirectionSouth() {
        Coordinate coordinate = new CoordinateBuilder().x(3).y(3).doBuild();
        Direction direction = new Compass.South();
        Position position = new PositionBuilder().coordinate(coordinate).direction(direction).doBuild();

        Position newPosition = positionService.changePosition(position, Command.R);

        Assertions.assertAll("TurnRightWhenDirectionSouth not changed",
                () -> Assertions.assertEquals(newPosition.getDirection(), new Compass.West()),
                () -> Assertions.assertEquals(newPosition.getCoordinate().getX(), position.getCoordinate().getX()),
                () -> Assertions.assertEquals(newPosition.getCoordinate().getY(), position.getCoordinate().getY()));
    }

    @Test
    public void shouldChangePositionTurnLeftWhenDirectionWest() {
        Coordinate coordinate = new CoordinateBuilder().x(3).y(3).doBuild();
        Direction direction = new Compass.West();
        Position position = new PositionBuilder().coordinate(coordinate).direction(direction).doBuild();

        Position newPosition = positionService.changePosition(position, Command.L);

        Assertions.assertAll("ChangePositionTurnRightWhenDirectionWest not changed",
                () -> Assertions.assertEquals(newPosition.getDirection(), new Compass.South()),
                () -> Assertions.assertEquals(newPosition.getCoordinate().getX(), position.getCoordinate().getX()),
                () -> Assertions.assertEquals(newPosition.getCoordinate().getY(), position.getCoordinate().getY()));
    }

    @Test
    public void shouldChangePositionTurnRightWhenDirectionWest() {
        Coordinate coordinate = new CoordinateBuilder().x(3).y(3).doBuild();
        Direction direction = new Compass.West();
        Position position = new PositionBuilder().coordinate(coordinate).direction(direction).doBuild();

        Position newPosition = positionService.changePosition(position, Command.R);

        Assertions.assertAll("ChangePositionTurnRightWhenDirectionWest not changed",
                () -> Assertions.assertEquals(newPosition.getDirection(), new Compass.North()),
                () -> Assertions.assertEquals(newPosition.getCoordinate().getX(), position.getCoordinate().getX()),
                () -> Assertions.assertEquals(newPosition.getCoordinate().getY(), position.getCoordinate().getY()));
    }

    @Test
    public void shouldChangePositionMove() {
        Coordinate coordinate = new CoordinateBuilder().x(3).y(3).doBuild();
        Direction direction = new Compass.East();
        Position position = new PositionBuilder().coordinate(coordinate).direction(direction).doBuild();

        Position newPosition = positionService.changePosition(position, Command.M);

        Assertions.assertAll("ChangePositionMove not changed",
                () -> Assertions.assertEquals(newPosition.getDirection(), position.getDirection()),
                () -> Assertions.assertEquals(newPosition.getCoordinate().getX(), position.getCoordinate().getX() + 1),
                () -> Assertions.assertEquals(newPosition.getCoordinate().getY(), position.getCoordinate().getY()));
    }

    @Test
    public void shouldChangePositionThrowExceptionWhenNullCommand() {
        Coordinate coordinate = new CoordinateBuilder().x(3).y(3).doBuild();
        Direction direction = new Compass.East();
        Position position = new PositionBuilder().coordinate(coordinate).direction(direction).doBuild();

        Assertions.assertThrows(NullPointerException.class, () -> {
            positionService.changePosition(position, null);
        });
    }

}