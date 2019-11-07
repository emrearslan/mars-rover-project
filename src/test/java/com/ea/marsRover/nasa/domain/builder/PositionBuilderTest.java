package com.ea.marsRover.nasa.domain.builder;

import com.ea.marsRover.nasa.domain.Compass;
import com.ea.marsRover.nasa.domain.Coordinate;
import com.ea.marsRover.nasa.domain.Direction;
import com.ea.marsRover.nasa.domain.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = PositionBuilder.class)
public class PositionBuilderTest {

    @Test
    public void shouldPositionBuilder() {
        Coordinate coordinate = new CoordinateBuilder().x(5).y(5).doBuild();
        Direction direction = new Compass.North();
        boolean rip = false;

        Position position = new PositionBuilder().coordinate(coordinate).direction(direction).rip(rip).doBuild();

        Assertions.assertAll("PositionBuilder fail",
                () -> Assertions.assertEquals(position.getCoordinate().getX(), coordinate.getX()),
                () -> Assertions.assertEquals(position.getCoordinate().getY(), coordinate.getY()),
                () -> Assertions.assertEquals(position.getDirection(), direction),
                () -> Assertions.assertEquals(position.isRip(), rip));

    }

}