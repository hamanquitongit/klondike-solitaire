package com.klondike.api.domain.beans;

import com.klondike.api.domain.beans.game.Table;
import lombok.Data;

@Data
public class GameState {
    // game id
    String gameId;
    // table
    Table table;
    // timer
}
