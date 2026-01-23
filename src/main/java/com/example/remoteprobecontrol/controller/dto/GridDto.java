package com.example.remoteprobecontrol.controller.dto;

import java.util.Set;

public record GridDto (
    int width,
    int height,
    Set<ObstracleDto> obstacles){

    public GridDto {
        if (obstacles == null) {
            obstacles = Set.of(); // default empty set
        }
    }
}


