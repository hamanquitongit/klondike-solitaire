package com.klondike.api.services;

import com.klondike.api.domain.beans.game.Table;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Getter
@Slf4j
@Service
public class InMemoryService {
//    private final List<PlayingCard> gameDeck = new LinkedList<>();
    private Table currTable;
    private final Map<String, Table> gameState = new ConcurrentHashMap<>();

    public void saveTable(Table table) {
        gameState.put("1", table);
    }
}
