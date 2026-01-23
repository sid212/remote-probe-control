package com.example.remoteprobecontrol.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProbeTest {

    Grid grid = new Grid(5,5);
    @Test
    void probeMovesForwardInFacingDirection(){
        Probe probe = new Probe(new Position(0,0), Direction.NORTH, grid);

        Probe result = probe.moveForward();

        assertEquals(new Position(0,1), result.getPosition());
        assertEquals(Direction.NORTH, result.getDirection());
    }

    @Test
    void probeMovesBackwardInFacingDirection(){
        Probe probe = new Probe(new Position(0,0), Direction.NORTH, grid);

        Probe result = probe.moveBackward();

        assertEquals(new Position(0,0), result.getPosition());
        assertEquals(Direction.NORTH, result.getDirection());
    }

    @Test
    void probeTurnsLeftWithoutChangingPosition(){
        Probe probe = new Probe(new Position(1,1), Direction.NORTH, grid);

        Probe result = probe.turnLeft();

        assertEquals(new Position(1,1), result.getPosition());
        assertEquals(Direction.WEST, result.getDirection());
    }

    @Test
    void probeTurnsRightWithoutChangingPosition(){
        Probe probe = new Probe(new Position(1,1), Direction.NORTH, grid);

        Probe result = probe.turnRight();

        assertEquals(new Position(1,1), result.getPosition());
        assertEquals(Direction.EAST, result.getDirection());
    }

    @Test
    void probeExecutesSequenceOfCommands() {
        Probe probe = new Probe(new Position(0,0), Direction.NORTH, grid);

        Probe result = probe.execute("FFR");

        assertEquals(new Position(0,2), result.getPosition());
        assertEquals(Direction.EAST, result.getDirection());
    }

    @Test
    void probeTracksVisitedPositionsWhileMoving() {
        Grid grid = new Grid(5,5);
        Probe probe = new Probe(new Position(0,0), Direction.NORTH, grid);

        Probe result = probe.execute("FFR");

        assertEquals(
                List.of(
                        new Position(0,0),
                        new Position(0,1),
                        new Position(0,2)
                ),
                result.getVisited()
        );
    }

}
