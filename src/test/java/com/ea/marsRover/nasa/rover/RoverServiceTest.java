package com.ea.marsRover.nasa.rover;

import com.ea.marsRover.application.MarsRoverApplication;
import com.ea.marsRover.message.MessageService;
import com.ea.marsRover.nasa.domain.*;
import com.ea.marsRover.nasa.domain.builder.CoordinateBuilder;
import com.ea.marsRover.nasa.domain.builder.PositionBuilder;
import com.ea.marsRover.nasa.domain.builder.RoverBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest(classes = MarsRoverApplication.class)
public class RoverServiceTest {

    @InjectMocks
    private RoverService roverService;

    @Mock
    private PositionService positionService;

    @Mock
    private MessageService messageService;

    private Rover rover1;
    private Rover rover2;
    private List<Rover> rovers;

    @BeforeEach
    void setUp() {
        Coordinate plateau1 = new CoordinateBuilder().x(5).y(5).doBuild();
        Coordinate coordinate1 = new CoordinateBuilder().x(3).y(3).doBuild();
        Direction direction1 = new Compass.East();
        Position position1 = new PositionBuilder().coordinate(coordinate1).direction(direction1).doBuild();

        List<Command> commands1 = Arrays.asList(Command.L, Command.M, Command.L,
                Command.M, Command.L, Command.M, Command.L, Command.M, Command.M);

        rover1 = new RoverBuilder().plateau(plateau1).position(position1).commands(commands1).doBuild();

        Coordinate plateau2 = new CoordinateBuilder().x(5).y(5).doBuild();
        Coordinate coordinate2 = new CoordinateBuilder().x(1).y(2).doBuild();
        Direction direction2 = new Compass.North();
        Position position2 = new PositionBuilder().coordinate(coordinate2).direction(direction2).doBuild();

        List<Command> commands2 = Arrays.asList(Command.M, Command.M, Command.R,
                Command.M, Command.M, Command.R, Command.M, Command.R, Command.R, Command.M);

        rover2 = new RoverBuilder().plateau(plateau2).position(position2).commands(commands2).doBuild();

        rovers = Arrays.asList(rover1, rover2);
    }

    @Test
    public void shouldExploreWithRover() {
        Mockito.when(positionService.changePosition(Mockito.any(Position.class), Mockito.any(Command.class)))
                .thenReturn(rover1.getPosition());
        roverService.explore(rover1);

        Mockito.verify(positionService, Mockito.times(rover1.getCommands().size()))
                .changePosition(Mockito.any(Position.class), Mockito.any(Command.class));
    }

    @Test
    public void shouldExploreNotChangePositionWhenEmptyCommands() {
        rover2.setCommands(new ArrayList<>());
        Position position = roverService.explore(rover2);

        Assertions.assertAll("Position changed",
                () -> Assertions.assertEquals(rover2.getPosition().getCoordinate().getX(), position.getCoordinate().getX()),
                () -> Assertions.assertEquals(rover2.getPosition().getCoordinate().getY(), position.getCoordinate().getY()),
                () -> Assertions.assertEquals(rover2.getPosition().getDirection(), position.getDirection()));
    }

    @Test
    public void shouldExploresWithRovers() {
        Mockito.when(positionService.changePosition(Mockito.any(Position.class), Mockito.any(Command.class)))
                .thenReturn(rover1.getPosition());
        roverService.explores(rovers);

        int totalCommandSize = rovers.stream().map(c -> c.getCommands() == null ? 0 : c.getCommands().size())
                .reduce(0, Integer::sum);

        Mockito.verify(positionService, Mockito.times(totalCommandSize))
                .changePosition(Mockito.any(Position.class), Mockito.any(Command.class));
    }

    @Test
    public void shouldExploreThrowExceptionWhenNullParam() {
        Mockito.when(messageService.getMessage(Mockito.anyString(), Mockito.any())).thenReturn("message");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            roverService.explore(null);
        });
    }

    @Test
    public void shouldExploresThrowExceptionWhenEmptyRovers() {
        Mockito.when(messageService.getMessage(Mockito.anyString(), Mockito.any())).thenReturn("message");
        List<Rover> emptyRovers = new ArrayList<>();

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            roverService.explores(emptyRovers);
        });
    }

    @Test
    public void shouldExploreSetRip() {
        Coordinate plateau = new CoordinateBuilder().x(1).y(1).doBuild();
        rover1.setPlateau(plateau);

        Position position = roverService.explore(rover1);

        Assertions.assertTrue(position.isRip(), "Rover not ripped");
    }

}