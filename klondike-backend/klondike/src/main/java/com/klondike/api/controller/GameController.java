package com.klondike.api.controller;

import com.klondike.api.domain.response.GameStartResponse;
import com.klondike.api.services.GameService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/klondike")
public class GameController {

    @Autowired
    GameService gameService;

    @PostMapping
    public GameStartResponse gameStart() {
        // game starting...
        gameService.dealInitialTable();
        return new GameStartResponse("Game Starting...");
    }
}
