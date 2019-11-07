package com.ea.marsRover.nasa.domain.builder;

import com.ea.marsRover.nasa.domain.Command;
import com.ea.marsRover.nasa.domain.Coordinate;
import com.ea.marsRover.nasa.domain.Position;
import com.ea.marsRover.nasa.domain.Rover;

import java.util.ArrayList;
import java.util.List;

public class RoverBuilder {

    private Coordinate plateau;
    private Position position;
    private List<Command> commands;

    public Rover doBuild() {
        Rover rover = new Rover();
        rover.setPlateau(plateau);
        rover.setPosition(position);
        rover.setCommands(commands);
        return rover;
    }

    public RoverBuilder plateau(Coordinate plateau) {
        this.plateau = plateau;
        return this;
    }

    public RoverBuilder position(Position position) {
        this.position = position;
        return this;
    }

    public RoverBuilder command(Command command) {
        if(this.commands == null) {
            this.commands = new ArrayList<>();
        }

        this.commands.add(command);
        return this;
    }

    public RoverBuilder commands(List<Command> commands) {
        if(this.commands == null) {
            this.commands = new ArrayList<>();
        }

        this.commands.addAll(commands);
        return this;
    }
}
