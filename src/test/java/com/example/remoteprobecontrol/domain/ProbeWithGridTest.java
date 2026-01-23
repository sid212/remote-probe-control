package com.example.remoteprobecontrol.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProbeWithGridTest {

    @Test
    void probeDoesNotMoveForwardOutsideGrid() {
        Grid grid = new Grid(5, 5);
        Probe probe = new Probe(
                new Position(0, 0),
                Direction.SOUTH,
                grid
        );

        Probe result = probe.moveForward();

        assertEquals(new Position(0, 0), result.getPosition());
        assertEquals(Direction.SOUTH, result.getDirection());
    }
}
