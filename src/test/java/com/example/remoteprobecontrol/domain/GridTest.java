package com.example.remoteprobecontrol.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GridTest {
    @Test
    void positionInsideGridIsValid() {
        Grid grid = new Grid(5, 5);

        assertTrue(grid.isValid(new Position(0, 0)));
        assertTrue(grid.isValid(new Position(4, 4)));
    }

    @Test
    void positionOutsideGridIsInvalid() {
        Grid grid = new Grid(5, 5);

        assertFalse(grid.isValid(new Position(5, 0)));
        assertFalse(grid.isValid(new Position(0, 5)));
        assertFalse(grid.isValid(new Position(-1, 0)));
    }
}
