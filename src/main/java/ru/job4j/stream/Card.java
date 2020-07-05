package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

public class Card {
    private Suit suit;
    private Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    public static void main(String[] args) {
        List<Suit> suits = List.of(Suit.values());
        List<Value> values = List.of(Value.values());
        List<Card> cards =
                suits.stream()
                    .flatMap(s -> values.stream()
                        .map(v -> new Card(s, v))).collect(Collectors.toList());
    }
}