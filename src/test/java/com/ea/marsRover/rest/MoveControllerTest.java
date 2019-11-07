package com.ea.marsRover.rest;

import com.ea.marsRover.application.MarsRoverApplication;
import com.ea.marsRover.nasa.domain.Position;
import com.ea.marsRover.nasa.domain.Rover;
import com.ea.marsRover.nasa.rover.RoverService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = MarsRoverApplication.class)
public class MoveControllerTest {

    @InjectMocks
    private MoveController moveController;

    @Mock
    private RoverService roverService;

    @Test
    public void shouldExplore() {
        Mockito.when(roverService.explore(Mockito.any(Rover.class))).thenReturn(new Position());

        moveController.explore(new Rover());
    }

    @Test
    public void shouldExplores() {
        List<Rover> input = new ArrayList<>();
        List<Position> result = new ArrayList<>();
        Mockito.when(roverService.explores(input)).thenReturn(result);

        moveController.explores(input);
    }


}