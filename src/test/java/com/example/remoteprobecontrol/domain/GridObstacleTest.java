package com.example.remoteprobecontrol.domain;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GridObstacleTest {

    @Test
    void gridDetectsObstacleAtPosition() {
        Position obstacle = new Position(1, 1);
        Grid grid = new Grid(5, 5, Set.of(obstacle));

        assertFalse(grid.isValid(new Position(1, 1)));
        assertTrue(grid.isValid(new Position(0, 0)));
    }
}
