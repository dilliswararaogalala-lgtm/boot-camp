package com.bootcamp.tw.p5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BagTest {
    @Test
    void shouldAbleToAddBallInBag() throws UnableToAddBallException, InvalidCapacityInputException, InvalidGreenBallStorageCountException, InvalidGreenRedBallRatioException {
        Bag bag = Bag.createBag(12);
        boolean isAdded = bag.add(new Ball(Color.GREEN));
        assertTrue(isAdded);
    }

    @Test
    void shouldThrowWhenBagIsFull() throws UnableToAddBallException, InvalidCapacityInputException, InvalidGreenBallStorageCountException, InvalidGreenRedBallRatioException {
        Bag bag = Bag.createBag(1);
        bag.add(new Ball(Color.GREEN));
        assertThrows(UnableToAddBallException.class, () -> bag.add(new Ball(Color.GREEN)));
    }

    @Test
    void shouldThrowWhenWeCreateBagWithNegativeValues() {
        assertThrows(InvalidCapacityInputException.class, () -> Bag.createBag(-1));
    }

    @Test
    void shouldAbleToAddColorBall() throws InvalidCapacityInputException, UnableToAddBallException, InvalidGreenBallStorageCountException, InvalidGreenRedBallRatioException {
        Bag bag = Bag.createBag(12);
        boolean isAdded = bag.add(new Ball(Color.BLUE));
        assertTrue(isAdded);
    }

    @Test
    void shouldAbleToAddGreenBallMoreThan3() throws InvalidCapacityInputException, UnableToAddBallException, InvalidGreenBallStorageCountException, InvalidGreenRedBallRatioException {
        Bag bag = Bag.createBag(12);
        assertTrue(bag.add(new Ball(Color.GREEN)));
        assertTrue(bag.add(new Ball(Color.GREEN)));
        assertTrue(bag.add(new Ball(Color.GREEN)));
        assertTrue(bag.add(new Ball(Color.BLUE)));

        assertThrows(InvalidGreenBallStorageCountException.class, () -> bag.add(new Ball(Color.GREEN)));
    }

    @Test
    void shouldNotAllowsRedBallToBeMoreThanTwiceOfGreen() throws InvalidCapacityInputException {
        Bag bag = Bag.createBag(12);
        assertThrows(InvalidGreenRedBallRatioException.class, () -> bag.add(new Ball(Color.RED)));
    }


    @Test
    void shouldNotAllowsRedBallToBeMoreThanTwiceOfGreenWhenOneGreenPresent() throws InvalidCapacityInputException, UnableToAddBallException, InvalidGreenBallStorageCountException, InvalidGreenRedBallRatioException {
        Bag bag = Bag.createBag(12);
        bag.add(new Ball(Color.GREEN));
        bag.add(new Ball(Color.RED));
        bag.add(new Ball(Color.RED));
        assertThrows(InvalidGreenRedBallRatioException.class, () -> bag.add(new Ball(Color.RED)));
    }


    @Test
    void shouldNotAllowsRedBallToBeMoreThanTwiceOfGreenWhenTwoGreenPresent() throws InvalidCapacityInputException, UnableToAddBallException, InvalidGreenBallStorageCountException, InvalidGreenRedBallRatioException {
        Bag bag = Bag.createBag(12);
        bag.add(new Ball(Color.GREEN));
        bag.add(new Ball(Color.GREEN));
        bag.add(new Ball(Color.RED));
        bag.add(new Ball(Color.RED));
        bag.add(new Ball(Color.RED));
        bag.add(new Ball(Color.RED));
        assertThrows(InvalidGreenRedBallRatioException.class, () -> bag.add(new Ball(Color.RED)));
    }

}
