package com.example.remoteprobecontrol.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PositionTest {

    @Test
    void moveForwardWhenFacingNorthIncrementsY() {
        Position start = new Position(0, 0);

        Position result = start.moveForward(Direction.NORTH);

        assertEquals(new Position(0, 1), result);
    }
}
