package com.ea.marsRover.nasa.domain.builder;

import com.ea.marsRover.nasa.domain.Coordinate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = CoordinateBuilder.class)
public class CoordinateBuilderTest {

    @Test
    public void shouldCoordinateBuilder() {
        int x = 5;
        int y = 5;

        Coordinate coordinate = new CoordinateBuilder().x(x).y(y).doBuild();

        Assertions.assertAll("CoordinateBuilder fail",
                () -> Assertions.assertEquals(coordinate.getX(), x),
                () -> Assertions.assertEquals(coordinate.getY(), y));
    }

}