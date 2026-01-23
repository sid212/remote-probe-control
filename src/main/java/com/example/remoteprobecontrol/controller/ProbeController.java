package com.example.remoteprobecontrol.controller;

import com.example.remoteprobecontrol.controller.dto.PositionDto;
import com.example.remoteprobecontrol.controller.dto.ProbeRequest;
import com.example.remoteprobecontrol.controller.dto.ProbeResponse;
import com.example.remoteprobecontrol.domain.Direction;
import com.example.remoteprobecontrol.domain.Grid;
import com.example.remoteprobecontrol.domain.Position;
import com.example.remoteprobecontrol.domain.Probe;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/probe")
public class ProbeController {

    @PostMapping("/execute")
    public ProbeResponse execute(@RequestBody ProbeRequest request) {

        Set<Position> obstacles = request.grid().obstacles().stream()
                .map(o -> new Position(o.x(), o.y()))
                .collect(Collectors.toSet());

        Grid grid = new Grid(
                request.grid().width(),
                request.grid().height(),
                obstacles
        );

        Probe probe = new Probe(
                new Position(request.start().x(), request.start().y()),
                Direction.valueOf(request.start().direction()),
                grid
        );

        Probe result = probe.execute(request.commands());

        return new ProbeResponse(
                new PositionDto(
                        result.getPosition().getX(),
                        result.getPosition().getY()
                ),
                result.getDirection().name()
        );

    }
}
