package com.example.remoteprobecontrol.domain;

public class Probe {
    private final Position position;
    private final Direction direction;
    private final Grid grid;

    public Probe(Position position, Direction direction, Grid grid) {
        this.position = position;
        this.direction = direction;
        this.grid = grid;
    }

    public Probe moveForward(){
        Position newPosition = position.moveForward(direction);
        return grid.isValid(newPosition) ? new Probe(newPosition, direction, grid)
                :this;
    }

    public Probe moveBackward() {
        Position newPosition = position.moveBackward(direction);
        return grid.isValid(newPosition) ? new Probe(newPosition,
                direction, grid) : this;
    }

    public Probe turnLeft() {
        return new Probe(position, direction.turnLeft(), grid);
    }

    public Probe turnRight() {
        return new Probe(position, direction.turnRight(), grid);
    }

    public Position getPosition() {
        return position;
    }

    public Direction getDirection() {
        return direction;
    }

    public Grid getGrid() {
        return grid;
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
