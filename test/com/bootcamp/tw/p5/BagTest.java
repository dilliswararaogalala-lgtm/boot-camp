package com.bootcamp.tw.p5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BagTest {
    @Test
    void shouldAbleToAddBallInBag() throws UnableToAddBallException {
        Bag bag = new Bag();
        boolean isAdded = bag.add(new Ball());
        assertTrue(isAdded);
    }

    @Test
    void shouldThrowWhenBagIsFull() throws UnableToAddBallException {
        Bag bag = new Bag();
        for (int i = 0 ; i < 12; i++){
            bag.add(new Ball());
        }
        assertThrows(UnableToAddBallException.class, ()-> bag.add(new Ball()));
    }
}
