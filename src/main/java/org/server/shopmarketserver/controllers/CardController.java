package org.server.shopmarketserver.controllers;

import org.server.shopmarketserver.entities.Card;
import org.server.shopmarketserver.entities.Response;
import org.server.shopmarketserver.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Market")
public class CardController {
    private CardRepository cardRepository;

    @Autowired
    public CardController(CardRepository cardRepository){
        this.cardRepository = cardRepository;
    }

    @PostMapping("/addCardItem")
    public Response addCardItem(@RequestBody Card card){
        if (card == null || card.getName() == null || card.getName().isEmpty()
        ||card.getImg() == null || card.getImg().isEmpty()
        || card.getReleaseDate() == null || card.getReleaseDate().isEmpty()){
            return new Response(false, "Card name is required.");
        }
       /*
        Card currentCard = cardRepository.findCardByName(card.getName());
        if (currentCard != null){
            return new Response(false,"This card is already exist.");
        }
        */

        cardRepository.save(card);
        return new Response(true,"Add card success.");
    }

    @GetMapping("/getAllDetails")
    public List<Card> getAllDetails(){
        return cardRepository.findAll().stream().toList();
    }

    @GetMapping("/getHowManyItemsInTheCart")
    public Response getHowManyItemsInTheCart(){
        int size = cardRepository.findAll().size();
        return new Response(true,String.valueOf(size));
    }

}
