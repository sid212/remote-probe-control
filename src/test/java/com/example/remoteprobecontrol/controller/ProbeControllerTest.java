package com.example.remoteprobecontrol.controller;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProbeControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void executeCommandsReturnsFinalProbeState() throws Exception {
        String request = """
        {
          "grid": {
            "width": 5,
            "height": 5,
            "obstacles": [{ "x": 1, "y": 1 }]
          },
          "start": {
            "x": 0,
            "y": 0,
            "direction": "NORTH"
          },
          "commands": "FFR"
        }
        """;

        mockMvc.perform(post("/probe/execute")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(request))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.finalPosition.x").value(0))
                .andExpect(jsonPath("$.finalPosition.y").value(2))
                .andExpect(jsonPath("$.direction").value("EAST"));
    }

    @Test
    void returnsBadRequestForInvalidDirection() throws Exception {
        String request = """
    {
      "grid": { "width": 5, "height": 5, "obstacles": [] },
      "start": { "x": 0, "y": 0, "direction": "UP" },
      "commands": "FF"
    }
    """;

        mockMvc.perform(post("/probe/execute")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(request))
                .andExpect(status().isBadRequest());
    }

    @Test
    void returnsBadRequestForInvalidCommand() throws Exception {
        String request = """
    {
      "grid": { "width": 5, "height": 5, "obstacles": [] },
      "start": { "x": 0, "y": 0, "direction": "NORTH" },
      "commands": "FXR"
    }
    """;

        mockMvc.perform(post("/probe/execute")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(request))
                .andExpect(status().isBadRequest());
    }
}
