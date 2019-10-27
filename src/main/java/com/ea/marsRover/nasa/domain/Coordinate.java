package com.ea.marsRover.nasa.domain;

public class Coordinate {

    private int x;
    private int y;

    public Coordinate() {

    }

    public Coordinate(int x, int y) throws IllegalArgumentException {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Coordinate move(int x, int y) {
        return new Coordinate(this.x + x, this.y + y);
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.x, this.y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coordinate that = (Coordinate) o;

        if (x != that.x) return false;
        if (y != that.y) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

}
