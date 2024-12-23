package org.server.shopmarketserver.service;

import org.server.shopmarketserver.entities.Card;

public class HelpMethods {

    public static boolean isNotValidCard(Card card){
        return (card == null || card.getName() == null || card.getName().isEmpty()
                || card.getImg() == null || card.getImg().isEmpty()
                || card.getReleaseDate() == null || card.getReleaseDate().isEmpty()
                || card.getQuantity() < 0);
    }
}

