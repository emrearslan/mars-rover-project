package com.ea.marsRover.nasa.domain;

public enum Command {

    L("Left"),
    R("Right"),
    M("Move");

    private String explain;

    Command(String explain) {
        this.explain = explain;
    }

    public String explain() {
        return explain;
    }

}
