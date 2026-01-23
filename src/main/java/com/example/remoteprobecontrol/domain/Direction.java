package com.example.remoteprobecontrol.domain;

public enum Direction {
    NORTH,
    EAST,
    SOUTH,
    WEST;

    public static Direction from(String value) {
        return switch (value.toUpperCase()) {
            case "NORTH" -> NORTH;
            case "EAST"  -> EAST;
            case "SOUTH" -> SOUTH;
            case "WEST"  -> WEST;
            default -> throw new IllegalArgumentException("Invalid direction: " + value);
        };
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
