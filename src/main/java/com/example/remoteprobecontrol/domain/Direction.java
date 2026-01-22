package com.example.remoteprobecontrol.domain;

public enum Direction {
    NORTH,
    EAST,
    SOUTH,
    WEST;

    public Direction turnLeft(){
        return switch (this) {
            case NORTH -> WEST;
            case WEST -> SOUTH;
            case SOUTH -> EAST;
            case EAST -> NORTH;
        };
    }
}
