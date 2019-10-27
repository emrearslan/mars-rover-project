package com.ea.marsRover.nasa.domain.builder;

import com.ea.marsRover.nasa.domain.Coordinate;

public class CoordinateBuilder {

    private int x;
    private int y;

    public Coordinate doBuild() {
        Coordinate coordinate = new Coordinate();
        coordinate.setX(x);
        coordinate.setY(y);
        return coordinate;
    }

    public CoordinateBuilder x(int x) {
        this.x = x;
        return this;
    }

    public CoordinateBuilder y(int y) {
        this.y = y;
        return this;
    }

}
