package com.example.remoteprobecontrol.controller.dto;

import java.util.List;

public record ProbeResponse(PositionDto finalPosition, String direction,List<PositionDto> visited) {}

