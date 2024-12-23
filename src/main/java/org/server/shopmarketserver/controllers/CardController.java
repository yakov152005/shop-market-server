package org.server.shopmarketserver.controllers;

import org.server.shopmarketserver.entities.Card;
import org.server.shopmarketserver.entities.Response;
import org.server.shopmarketserver.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.server.shopmarketserver.service.HelpMethods.isNotValidCard;

@RestController
@RequestMapping("/market")
public class CardController {
    private CardRepository cardRepository;

    @Autowired
    public CardController(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @PostMapping("/add-cart-item")
    public Response addCardItem(@RequestBody List<Card> cards) {
        for (Card card : cards) {
            if (isNotValidCard(card)) {
                return new Response(false, "Card details are incomplete.");
            }

        Card existingCard = cardRepository.findCardByName(card.getName());
        if (existingCard != null) {
            int newQuantity = existingCard.getQuantity() + card.getQuantity();
            existingCard.setQuantity(newQuantity);
            int newCost = existingCard.getCost() + card.getCost();
            existingCard.setCost(newCost);
            cardRepository.save(existingCard);
        } else {
            cardRepository.save(card);
        }
    }
        return new Response(true,"Cards added/updated successfully.");
}

@GetMapping("/get-all-details")
public List<Card> getAllDetails() {
    return cardRepository.findAll().stream().toList();
}

@GetMapping("/get-how-many-items-cart")
public Response getHowManyItemsInTheCart() {
    int size = 0;
    for (Card card : cardRepository.findAll()) {
        size += card.getQuantity();
    }
    return new Response(true, String.valueOf(size));
}

@GetMapping("/get-total-price-cart")
public Response getTotalPriceInTheCart() {
    int totalPrice = 0;
    for (Card card : cardRepository.findAll()) {
        totalPrice += card.getCost();
    }
    return new Response(true, String.valueOf(totalPrice));
}

}
