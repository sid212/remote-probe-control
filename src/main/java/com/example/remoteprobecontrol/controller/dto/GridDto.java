package com.example.remoteprobecontrol.controller.dto;

import java.util.Set;

public record GridDto (
    int width,
    int height,
    Set<ObstracleDto> obstacles){

    public GridDto {
        if (width <= 0) {
            throw new IllegalArgumentException("Width must be positive");
        }
        if (height <= 0) {
            throw new IllegalArgumentException("Height must be positive");
        }
        if (obstacles == null) {
            obstacles = Set.of(); // default empty set
        }
    }
}


