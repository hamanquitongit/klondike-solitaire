package com.klondike.api.domain.beans.game;

import lombok.Data;

import java.util.ArrayDeque;

@Data
public class Foundation {
    ArrayDeque<PlayingCard> clubPile;
    ArrayDeque<PlayingCard> spadePile;
    ArrayDeque<PlayingCard> heartPile;
    ArrayDeque<PlayingCard> diamondPile;
}
