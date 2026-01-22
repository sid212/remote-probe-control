package com.example.remoteprobecontrol.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DirectionTest {
    @Test
    void northTurnsLeftToWest() {
        Direction direction = Direction.NORTH;

        Direction result = direction.turnLeft();

        assertEquals(Direction.WEST, result);
    }

    @Test
    void northTurnsRightToEast() {
        Direction direction = Direction.NORTH;

        Direction result = direction.turnRight();

        assertEquals(Direction.EAST, result);
    }

    @Test
    void moveBackwardWhenFacingNorthDecrementsY() {
        Position start = new Position(0, 0);

        Position result = start.moveBackward(Direction.NORTH);

        assertEquals(new Position(0, -1), result);
    }
}
