package com.example.remoteprobecontrol.domain;

public enum Direction {
    NORTH,
    EAST,
    SOUTH,
    WEST;

    public static Direction valueOf(Direction direction) {
        return direction;
    }

    public Direction turnLeft(){
        return switch (this) {
            case NORTH -> WEST;
            case WEST -> SOUTH;
            case SOUTH -> EAST;
            case EAST -> NORTH;
        };
    }

    public Direction turnRight() {
        return switch (this) {
            case NORTH -> EAST;
            case EAST -> SOUTH;
            case SOUTH -> WEST;
            case WEST -> NORTH;
        };
    }}
