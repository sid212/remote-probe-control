package com.example.remoteprobecontrol.domain;

public class Probe {
    private final Position position;
    private final Direction direction;

    public Probe(Position position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }

    public Probe moveForward(){
        Position newPosition = position.moveForward(direction);
        return new Probe(newPosition, direction);
    }

    public Position getPosition() {
        return position;
    }

    public Direction getDirection() {
        return direction;
    }


}
