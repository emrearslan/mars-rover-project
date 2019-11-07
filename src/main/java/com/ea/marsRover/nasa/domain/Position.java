package com.ea.marsRover.nasa.domain;

import java.util.Objects;

public class Position {

    private Coordinate coordinate;
    private Direction direction;
    private boolean rip = false;

    public Position() {

    }

    public Position(Coordinate coordinate, Direction direction) {
        this.coordinate = coordinate;
        this.direction = direction;
    }

    public Position(Coordinate coordinate, Direction direction, boolean rip) {
        this.coordinate = coordinate;
        this.direction = direction;
        this.rip = rip;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public boolean isRip() {
        return rip;
    }

    public void setRip(boolean rip) {
        this.rip = rip;
    }

    public boolean isMovable(Coordinate plateau) {
        return !(coordinate.getX() > plateau.getX() ||
                coordinate.getY() > plateau.getY() ||
                coordinate.getX() < 0 || coordinate.getY() < 0);
    }

    @Override
    public String toString() {
        return String.format("%s %s", coordinate, direction);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position = (Position) o;

        if (!Objects.equals(coordinate, position.coordinate)) return false;
        return Objects.equals(direction, position.direction);
    }

    @Override
    public int hashCode() {
        int result = coordinate != null ? coordinate.hashCode() : 0;
        result = 31 * result + (direction != null ? direction.hashCode() : 0);
        return result;
    }

}
