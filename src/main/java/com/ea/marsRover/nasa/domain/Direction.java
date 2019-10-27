package com.ea.marsRover.nasa.domain;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "compass")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Compass.East.class, name = "E"),
        @JsonSubTypes.Type(value = Compass.West.class, name = "W"),
        @JsonSubTypes.Type(value = Compass.North.class, name = "N"),
        @JsonSubTypes.Type(value = Compass.South.class, name = "S")})
public interface Direction {

    Direction turnLeft();
    Direction turnRight();

    int moveX();
    int moveY();

    String toString();

}
