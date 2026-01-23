package com.example.remoteprobecontrol.domain;

import java.util.Set;

public class Grid {
    private final int width;
    private final int height;
    private final Set<Position> obstacles;

    public Grid(int width, int height) {
        this(width,height,Set.of());
    }

    public Grid(int width, int height, Set<Position> obstacles) {
        this.width = width;
        this.height = height;
        this.obstacles = obstacles;
    }

    public boolean isValid(Position position) {
        boolean insideBounds = position.getX() >= 0 &&
                position.getX() < width &&
                position.getY() >= 0 &&
                position.getY() < height;
        return insideBounds && !obstacles.contains(position);
    }
}
