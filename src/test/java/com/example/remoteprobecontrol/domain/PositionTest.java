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

    @Test
    void moveForwardWhenFacingEastIncrementsX() {
        Position start = new Position(0, 0);

        Position result = start.moveForward(Direction.EAST);

        assertEquals(new Position(1, 0), result);
    }

    @Test
    void moveForwardWhenFacingSouthDecrementsY() {
        Position start = new Position(0, 0);

        Position result = start.moveForward(Direction.SOUTH);

        assertEquals(new Position(0, -1), result);
    }

    @Test
    void moveForwardWhenFacingWestIncrementsX() {
        Position start = new Position(0, 0);

        Position result = start.moveForward(Direction.WEST);

        assertEquals(new Position(-1, 0), result);
    }

    @Test
    void moveBackwardWhenFacingNorthDecrementsY() {
        Position start = new Position(0, 0);

        Position result = start.moveBackward(Direction.NORTH);

        assertEquals(new Position(0, -1), result);
    }

    @Test
    void moveBackwardWhenFacingSouthIncrementsY() {
        Position start = new Position(0, 0);

        Position result = start.moveBackward(Direction.SOUTH);

        assertEquals(new Position(0, 1), result);
    }

    @Test
    void moveBackwardWhenFacingEastDecrementsX() {
        Position start = new Position(0, 0);

        Position result = start.moveBackward(Direction.EAST);

        assertEquals(new Position(-1, 0), result);
    }

    @Test
    void moveBackwardWhenFacingWestIncrementsX() {
        Position start = new Position(0, 0);

        Position result = start.moveBackward(Direction.WEST);

        assertEquals(new Position(1, 0), result);
    }
}
