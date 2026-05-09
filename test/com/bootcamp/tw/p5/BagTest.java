package com.bootcamp.tw.p5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BagTest {
    @Test
    void shouldAbleToAddBallInBag() throws UnableToAddBallException, InvalidCapacityInputException, InvalidGreenBallStorageCountException {
        Bag bag = Bag.createBag(12);
        boolean isAdded = bag.add(new Ball(Color.RED));
        assertTrue(isAdded);
    }

    @Test
    void shouldThrowWhenBagIsFull() throws UnableToAddBallException, InvalidCapacityInputException, InvalidGreenBallStorageCountException {
        Bag bag = Bag.createBag(1);
        bag.add(new Ball(Color.RED));
        assertThrows(UnableToAddBallException.class, ()-> bag.add(new Ball(Color.RED)));
    }

    @Test
    void shouldThrowWhenWeCreateBagWithNegativeValues()  {
        assertThrows(InvalidCapacityInputException.class, ()-> Bag.createBag(-1));
    }

    @Test
    void shouldAbleToAddColorBall() throws InvalidCapacityInputException, UnableToAddBallException, InvalidGreenBallStorageCountException {
        Bag bag = Bag.createBag(12);
        boolean isAdded = bag.add(new Ball(Color.BLUE));
        assertTrue(isAdded);
    }

    @Test
    void shouldAbleToAddGreenBallMoreThan3() throws InvalidCapacityInputException, UnableToAddBallException, InvalidGreenBallStorageCountException {
        Bag bag = Bag.createBag(12);
        assertTrue(bag.add(new Ball(Color.GREEN)));
        assertTrue(bag.add(new Ball(Color.GREEN)));
        assertTrue(bag.add(new Ball(Color.GREEN)));
        assertTrue(bag.add(new Ball(Color.BLUE)));

        assertThrows( InvalidGreenBallStorageCountException.class, ()->bag.add(new Ball(Color.GREEN)));

    }
}
