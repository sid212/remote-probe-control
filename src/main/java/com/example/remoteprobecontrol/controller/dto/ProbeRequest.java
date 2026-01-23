package com.example.remoteprobecontrol.controller.dto;

import com.example.remoteprobecontrol.domain.Grid;

public record ProbeRequest (
        GridDto grid,
        StartDto start,
        String commands){}


