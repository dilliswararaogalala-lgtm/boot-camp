package com.bootcamp.tw.p2;

import jdk.jfr.Description;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChanceTest {
    @Test
    @Description("Represent the chance of getting Tail")
    void getChanceWhenWeCalledChanceOf() {
        Chance gettingTail = Chance.create(0.5);
        assertEquals(0.5, gettingTail.getChance());
    }

    @Test
    @Description("Represent the chance of not getting Tail")
    void getNotChanceWhenWeCalledGetNotChanceOf() {
        Chance gettingTail = Chance.create(0.2);
        Chance notGettingChance = gettingTail.not();
        assertEquals(0.8, notGettingChance.getChance());
    }

    @Test
    @Description("Represent the chance to get tail when we flip 2 coins")
    void chanceToGetTailWhenWeFlippedTwoCoins() {
        Chance gettingTail = Chance.create(0.25);
        assertEquals(0.25, gettingTail.getChance());
    }

    @Test
    @Description("Represent the chance of not getting Tail when we flip 2 coins")
    void chanceToNotGetTailWhenWeFlippedTwoCoins() {
        Chance gettingTail = Chance.create(0.25);
        Chance notGettingChance = gettingTail.not();
        assertEquals(0.75, notGettingChance.getChance());
    }

    @Test
    @Description("Represent the chance to get tail when we flip 2 coins")
    void chanceToGetThreeWhenWeRollDice() {
        Chance gettingThreeChanceInDice = Chance.create(1, 6);
        assertEquals(new Chance(1, 0, 6), gettingThreeChanceInDice);
    }

    


}
