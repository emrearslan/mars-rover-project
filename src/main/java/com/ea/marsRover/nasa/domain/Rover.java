package com.ea.marsRover.nasa.domain;

import java.util.List;
import java.util.Objects;

public class Rover {

    private Position position;
    private List<Command> commands;

    public Rover() {

    }

    public Rover(Position position, List<Command> commands) {
        this.position = position;
        this.commands = commands;
    }

    public Position getPosition() {
        return this.position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public List<Command> getCommands() {
        return this.commands;
    }

    public void setCommands(List<Command> commands) {
        this.commands = commands;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rover rover = (Rover) o;

        if (!Objects.equals(position, rover.position)) return false;
        return Objects.equals(commands, rover.commands);
    }

    @Override
    public int hashCode() {
        int result = position != null ? position.hashCode() : 0;
        result = 31 * result + (commands != null ? commands.hashCode() : 0);
        return result;
    }

}
