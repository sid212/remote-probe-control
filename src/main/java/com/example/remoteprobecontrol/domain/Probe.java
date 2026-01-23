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

    public Probe moveBackward() {
        return new Probe(position.moveBackward(direction),
                direction);
    }

    public Probe turnLeft() {
        return new Probe(position, direction.turnLeft());
    }

    public Probe turnRight() {
        return new Probe(position, direction.turnRight());
    }

    public Position getPosition() {
        return position;
    }

    public Direction getDirection() {
        return direction;
    }

    public Probe execute(String commands) {
        Probe current = this;
        for(char command : commands.toCharArray())
            current = switch (command) {
                case 'F' -> current.moveForward();
                case 'B' -> current.moveBackward();
                case 'L' -> current.turnLeft();
                case 'R' -> current.turnRight();
                default  -> throw new IllegalArgumentException(
                        "Unknown command: " + command
                );
            };
        return current;
    }

}
