package com.ea.marsRover.nasa.domain.builder;

import com.ea.marsRover.nasa.domain.Coordinate;
import com.ea.marsRover.nasa.domain.Direction;
import com.ea.marsRover.nasa.domain.Position;

public class PositionBuilder {

    private Coordinate coordinate;
    private Direction direction;

    public Position doBuild() {
        Position position = new Position();
        position.setCoordinate(coordinate);
        position.setDirection(direction);
        return position;
    }

    public PositionBuilder coordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
        return this;
    }

    public  PositionBuilder direction(Direction direction) {
        this.direction = direction;
        return this;
    }
}
