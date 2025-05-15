package com.klondike.api.domain.constants;

import lombok.Getter;

@Getter
public enum Suits {

    CLUBS("CLUBS", false),
    SPADES("SPADES", false),
    HEARTS("HEARTS", true),
    DIAMONDS("DIAMONDS", true);

    @Getter
    private final String suitName;
    @Getter
    private final boolean isRed;

    Suits(String suitName, boolean isRed) {
        this.suitName = suitName;
        this.isRed = isRed;
    }

}
