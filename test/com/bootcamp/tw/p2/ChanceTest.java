package com.bootcamp.tw.p2;

import jdk.jfr.Description;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChanceTest {
    @Test
    @Description("Represent the chance of getting Tail")
    void getChanceWhenWeCalledChanceOf() {
        Chance gettingTail = Chance.create(0.5);
        assertEquals(new Chance(0.5), gettingTail);
    }

    @Test
    @Description("Represent the chance of not getting Tail")
    void getNotChanceWhenWeCalledGetNotChanceOf() {
        Chance gettingTail = Chance.create(0.2);
        Chance notGettingChance = gettingTail.not();
        assertEquals( Chance.create(0.8), notGettingChance);
    }

    @Test
    @Description("Represent the chance of getting Tail in both coin when we flip 2 coins")
    void chanceToNotGetTailWhenWeFlippedTwoCoins() {
        Chance gettingTailInCoin1 = Chance.create(0.5);
        Chance gettingTailInCoin2 = Chance.create(0.5);

        Chance gettingTailInBothChance = gettingTailInCoin1.intersection(gettingTailInCoin2);
        assertEquals(Chance.create(0.25), gettingTailInBothChance);
    }


    @Test
    @Description("Represent the chance of at least one Tail when we flip 2 coins")
    void chanceOfGettingTailOnBothCoins() {
        Chance gettingTailInCoin1 = Chance.create(0.5);
        Chance gettingTailInCoin2 = Chance.create(0.5);

        Chance gettingTailInAnyOne = gettingTailInCoin1.union(gettingTailInCoin2);

        assertEquals(Chance.create(0.75), gettingTailInAnyOne);
    }
    @Test
    @Description("Represent the chance to get 3 when we roll dice")
    void chanceToGetThreeWhenWeRollDice() {
        Chance gettingThreeChanceInDice = Chance.create(1, 6);
        assertEquals(new Chance((double) 1 /6), gettingThreeChanceInDice);
    }
}
