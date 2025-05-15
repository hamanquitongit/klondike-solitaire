package com.klondike.api.domain.beans.game;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayDeque;
import java.util.List;

@Data
@Builder
public class Table {
    // foundations
    final Foundation foundationPile;
    // columns
    final List<ArrayDeque<PlayingCard>> gameColumns;
    // stock
    final ArrayDeque<PlayingCard> stockPile;
    // waste
    final ArrayDeque<PlayingCard> wastePile;

    Table(Foundation foundation, List<ArrayDeque<PlayingCard>> gameColumns, ArrayDeque<PlayingCard> stockPile, ArrayDeque<PlayingCard> wastePile) {
        this.foundationPile = foundation;
        this.gameColumns = gameColumns;
        this.stockPile = stockPile;
        this.wastePile = wastePile;
    }
}
