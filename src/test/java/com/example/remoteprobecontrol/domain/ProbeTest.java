package com.example.remoteprobecontrol.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProbeTest {

    @Test
    void probeMovesForwardInFacingDirection(){
        Probe probe = new Probe(new Position(0,0), Direction.NORTH);

        Probe result = probe.moveForward();

        assertEquals(new Position(0,1), result.getPosition());
        assertEquals(Direction.NORTH, result.getDirection());
    }

}
