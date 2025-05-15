package com.klondike.api.services;

import com.klondike.api.domain.beans.game.PlayingCard;
import com.klondike.api.domain.beans.game.Table;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Deque;
import java.util.List;

@Service
@Slf4j
public class GameService {

    @Autowired
    CardService cardService;


    public void dealInitialTable() {
        // shuffle deck ()
        Deque<PlayingCard> deck = cardService.generateDeckOfCards();
        log.info("DECK GENERATED: {}", deck);
        Deque<PlayingCard> shuffledDeck = cardService.shuffleDeck(deck);
        log.info("DECK SHUFFLED: {}", shuffledDeck);
        // generate a table and deal cards
        Table table = cardService.dealTable(shuffledDeck);


    }
}
