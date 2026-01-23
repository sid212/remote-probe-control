package com.example.remoteprobecontrol.domain;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProbeObstracleTest {

    @Test
    void probeStopsBeforeObstacle() {
        Grid grid = new Grid(
                5,
                5,
                Set.of(new Position(0, 1))
        );

        Probe probe = new Probe(
                new Position(0, 0),
                Direction.NORTH,
                grid
        );

        Probe result = probe.moveForward();

        assertEquals(new Position(0, 0), result.getPosition());
        assertEquals(Direction.NORTH, result.getDirection());
    }
}
