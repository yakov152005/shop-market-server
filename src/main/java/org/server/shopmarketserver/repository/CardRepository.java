package org.server.shopmarketserver.repository;

import org.server.shopmarketserver.entities.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card,Integer> {
    public Card findCardByName(String cardName);
}
