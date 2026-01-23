package com.example.remoteprobecontrol.domain;

import java.util.ArrayList;
import java.util.List;

public class Probe {
    private final Position position;
    private final Direction direction;
    private final Grid grid;
    private final List<Position> visited;

    public Probe(Position position, Direction direction, Grid grid) {
        this(position,direction,grid,List.of(position));
    }

    private Probe(Position position,
                  Direction direction,
                  Grid grid,
                  List<Position> visited) {
        this.position = position;
        this.direction = direction;
        this.grid = grid;
        this.visited = visited;
    }

    public Probe moveForward(){
        Position newPosition = position.moveForward(direction);
        if (!grid.isValid(newPosition)) {
            return this;
        }

        List<Position> newVisited = new ArrayList<>(visited);
        newVisited.add(newPosition);

        return new Probe(newPosition, direction, grid, newVisited);
    }

    public Probe moveBackward() {
        Position newPosition = position.moveBackward(direction);
        if (!grid.isValid(newPosition)) {
            return this;
        }
        List<Position> newVisited = new ArrayList<>(visited);
        newVisited.add(newPosition);
        return new Probe(newPosition,direction, grid,newVisited);
    }

    public Probe turnLeft() {
        return new Probe(position, direction.turnLeft(), grid, visited);
    }

    public Probe turnRight() {
        return new Probe(position, direction.turnRight(), grid, visited);
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

    public List<Position> getVisited() {
        return List.copyOf(visited);
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
