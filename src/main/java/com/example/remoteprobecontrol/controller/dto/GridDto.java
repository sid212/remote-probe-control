package com.example.remoteprobecontrol.controller.dto;

import com.example.remoteprobecontrol.domain.Position;

import java.util.List;
import java.util.Set;

public record GridDto (
    int width,
    int height,
    Set<ObstracleDto> obstacles){}


