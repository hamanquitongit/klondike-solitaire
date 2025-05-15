package com.klondike.api.domain.beans.game;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PlayingCard {
    String display;
    Suit suit;
    int value;
    boolean isFaceDown;
}
