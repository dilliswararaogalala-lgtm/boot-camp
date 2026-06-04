package com.bootcamp.tw.p5;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class BagTest {
    @Test
    void shouldAbleToAddBallInBag() throws InvalidInputException {
        Bag bag = Bag.createBag(12);
        boolean isAdded = bag.add(new Ball(Color.GREEN));
        assertTrue(isAdded);
    }

    @Test
    void shouldThrowWhenBagIsFull() throws InvalidInputException {
        Bag bag = Bag.createBag(1);
        bag.add(new Ball(Color.GREEN));
        assertThrows(UnableToAddBallException.class, () -> bag.add(new Ball(Color.GREEN)));
    }

    @Test
    void shouldThrowWhenWeCreateBagWithNegativeValues() {
        assertThrows(InvalidCapacityInputException.class, () -> Bag.createBag(-1));
    }

    @Test
    void shouldAbleToAddColorBall() throws InvalidInputException {
        Bag bag = Bag.createBag(12);
        boolean isAdded = bag.add(new Ball(Color.BLUE));
        assertTrue(isAdded);
    }

    @Test
    void shouldNotAbleToAddGreenBallMoreThan3() throws InvalidInputException {
        Bag bag = Bag.createBag(12);
        assertTrue(bag.add(new Ball(Color.GREEN)));
        assertTrue(bag.add(new Ball(Color.GREEN)));
        assertTrue(bag.add(new Ball(Color.GREEN)));
        assertTrue(bag.add(new Ball(Color.BLUE)));

        assertThrows(InvalidGreenBallStorageCountException.class, () -> bag.add(new Ball(Color.GREEN)));
    }

    @Test
    void shouldNotAllowsRedBallToBeMoreThanTwiceOfGreen() throws InvalidInputException {
        Bag bag = Bag.createBag(12);
        assertThrows(InvalidGreenRedBallRatioException.class, () -> bag.add(new Ball(Color.RED)));
    }


    @Test
    void shouldNotAllowsRedBallToBeMoreThanTwiceOfGreenWhenOneGreenPresent() throws InvalidInputException {
        Bag bag = Bag.createBag(12);
        bag.add(new Ball(Color.GREEN));
        bag.add(new Ball(Color.RED));
        bag.add(new Ball(Color.RED));
        assertThrows(InvalidGreenRedBallRatioException.class, () -> bag.add(new Ball(Color.RED)));
    }


    @Test
    void shouldNotAllowsRedBallToBeMoreThanTwiceOfGreenWhenTwoGreenPresent() throws InvalidInputException {
        Bag bag = Bag.createBag(12);
        bag.add(new Ball(Color.GREEN));
        bag.add(new Ball(Color.GREEN));
        bag.add(new Ball(Color.RED));
        bag.add(new Ball(Color.RED));
        bag.add(new Ball(Color.RED));
        bag.add(new Ball(Color.RED));
        assertThrows(InvalidGreenRedBallRatioException.class, () -> bag.add(new Ball(Color.RED)));
    }

    @Test
    void yellowBallShouldNotBeMoreThan40PercentOfTotalAddedBalls() throws InvalidInputException {
        Bag bag = Bag.createBag(12);
        bag.add(new Ball(Color.GREEN));
        bag.add(new Ball(Color.GREEN));
        bag.add(new Ball(Color.YELLOW));
        assertThrows(InvalidYellowBallRatioException.class, () -> bag.add(new Ball(Color.YELLOW)));
    }

    @Test
    void shouldAbleToAddAnyNoOfBlueBalls() throws InvalidInputException {
        Bag bag = Bag.createBag(3);
        assertTrue(bag.add(new Ball(Color.BLUE)));
        assertTrue(bag.add(new Ball(Color.BLUE)));
        assertTrue(bag.add(new Ball(Color.BLUE)));
    }


    @Test
    void shouldBeAbleToChooseCustomRules() throws InvalidInputException {
        ArrayList<Rule> rules = new ArrayList<>();
        rules.add(Rule.validateRedGreenRatio);
        rules.add(Rule.validateYellowBallRatio);

        Bag bag = Bag.createBagWithRules(12, rules);
        assertTrue(bag.add(new Ball(Color.GREEN)));
        assertTrue(bag.add(new Ball(Color.GREEN)));
        assertTrue(bag.add(new Ball(Color.GREEN)));
        assertTrue(bag.add(new Ball(Color.GREEN)));
        assertTrue(bag.add(new Ball(Color.GREEN)));
    }

    @Test
    void getSummaryOfBagAtAnyTime() throws InvalidInputException {
        Bag bag = Bag.createBag(12);
        addBallsToBag(bag, 4, Color.BLUE);
        addBallsToBag(bag, 2, Color.GREEN);
        addBallsToBag(bag, 4, Color.RED);
        addBallsToBag(bag, 2, Color.YELLOW);
        assertEquals("""
                Blue   : 4
                Green  : 2
                Red    : 4
                Yellow : 2
                
                Total  : 12""", bag.toString());

    }

    private void addBallsToBag(Bag bag, int ballsCount, Color color) throws InvalidInputException {
        for(int i = 0; i < ballsCount; i++){
            bag.add(new Ball(color));
        }
    }

}
