package com.example.remoteprobecontrol.controller.dto;

import com.example.remoteprobecontrol.domain.Direction;

public record StartDto(
        int x,
        int y,
        Direction direction
) {
}
