package com.klondike.api.services;

import com.klondike.api.domain.beans.game.Foundation;
import com.klondike.api.domain.beans.game.PlayingCard;
import com.klondike.api.domain.beans.game.Suit;
import com.klondike.api.domain.beans.game.Table;
import com.klondike.api.domain.constants.CardData;
import com.klondike.api.domain.constants.Suits;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.*;

@Service
@Slf4j
public class CardService {

    Deque<PlayingCard> generateDeckOfCards() {
        Deque<PlayingCard> deck = new ArrayDeque<>();
        for(CardData cardData: CardData.values()) {
            for(Suits suits : Suits.values()) {
                PlayingCard card = PlayingCard.builder()
                        .display(cardData.getDisplay())
                        .value(cardData.getValue())
                        .suit(new Suit(suits.getSuitName(), suits.isRed()))
                        .build();
                log.info("Adding card to deck: {}", card);
                deck.push(card);
            }
        }

        return deck;
    }

    Deque<PlayingCard> shuffleDeck(Deque<PlayingCard> deck) {
        List<PlayingCard> tempList = new ArrayList<>(deck);
        Collections.shuffle(tempList);
        deck.clear();
        deck.addAll(tempList);
        return deck;
    }

    Table dealTable(Deque<PlayingCard> deck) {
        return Table.builder()
                .foundationPile(new Foundation())
                .stockPile(new ArrayDeque<>())
                .wastePile(new ArrayDeque<>())
                .gameColumns(dealColumns(deck))
                .build();
    }

   private List<ArrayDeque<PlayingCard>> dealColumns(Deque<PlayingCard> deck) {
       List<ArrayDeque<PlayingCard>> holder = generateColumnHolder();
       log.info("Holder size: {}", holder.size());
       int row = 0;
       while(row < NUM_COLUMNS) {
           ListIterator<ArrayDeque<PlayingCard>> iterator = holder.listIterator(row);
           while (iterator.hasNext()) {
               int columnIdx = iterator.nextIndex();
               log.info("COL: {}",columnIdx);
               log.info("col size: {}", holder.get(columnIdx).size());
               PlayingCard cardToPush = deck.pop();
               cardToPush.setFaceDown(holder.get(columnIdx).size() != (columnIdx));
               log.info("Card to push: {}", cardToPush);
               iterator.next().push(cardToPush);
           }
           row++;
           log.info("[{}] [{}] [{}] [{}] [{}] [{}] [{}]", holder.get(0).size(), holder.get(1).size(), holder.get(2).size(), holder.get(3).size(), holder.get(4).size(), holder.get(5).size(), holder.get(6).size());
       }
//       log.info("holder: {}", holder);
       return holder;
   }

   private List<ArrayDeque<PlayingCard>> generateColumnHolder() {
        List<ArrayDeque<PlayingCard>> holder = new ArrayList<>();
        int count = 0;
        while(count != 7) {
            holder.add(new ArrayDeque<>());
            count++;
        }
       log.info((holder.size() == 7) ? "holder now has 7 columns" : "error in generating 7 columns");
        return holder;
   }

    private final int NUM_COLUMNS = 7;
    private final int NUM_COLUMN_CARDS = 28;

}
