package com.klondike.api.domain.constants;

import lombok.Getter;

@Getter
public enum CardData {
    KING("K",13),
    QUEEN("Q",12),
    JACK("J",11),
    TEN("10",10),
    NINE("9",9),
    EIGHT("8",8),
    SEVEN("7",7),
    SIX("6",6),
    FIVE("5",5),
    FOUR("4",4),
    THREE("3",3),
    TWO("2",2),
    ACE("A",1);

    @Getter
    private final String display;
    @Getter
    private final int value;

    CardData(String display, int value) {
        this.display = display;
        this.value = value;
    }
}
