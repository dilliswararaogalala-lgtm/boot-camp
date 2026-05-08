package com.bootcamp.tw.p2;

import jdk.jfr.Description;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ChanceTest {
    @Test
    @Description("Represent the chance of not getting Tail")
    void getNotChanceWhenWeCalledGetComplimentChanceOf() throws InvalidChanceArgument {
        Chance gettingTail = Chance.create(0.2);
        Chance notGettingChance = gettingTail.compliment();
        assertEquals( Chance.create(0.8), notGettingChance);
    }

    @Test
    @Description("Represent the chance of getting Tail in both coin when we flip 2 coins")
    void chanceToComplimentGetTailWhenWeFlippedTwoCoins() throws InvalidChanceArgument {
        Chance gettingTailInCoin1 = Chance.create(0.5);
        Chance gettingTailInCoin2 = Chance.create(0.5);

        Chance gettingTailInBothChance = gettingTailInCoin1.intersection(gettingTailInCoin2);
        assertEquals(Chance.create(0.25), gettingTailInBothChance);
    }


    @Test
    @Description("Represent the chance of at least one Tail when we flip 2 coins")
    void chanceOfGettingTailOnBothCoins() throws InvalidChanceArgument {
        Chance gettingTailInCoin1 = Chance.create(0.5);
        Chance gettingTailInCoin2 = Chance.create(0.5);

        Chance gettingTailInAnyOne = gettingTailInCoin1.union(gettingTailInCoin2);

        assertEquals(Chance.create(0.75), gettingTailInAnyOne);
    }
    @Test
    @Description("Represent the chance to get 3 when we roll dice")
    void chanceToGetThreeWhenWeRollDice() throws InvalidChanceArgument {
        Chance gettingThreeChanceInDice = Chance.create(1, 6);
        assertEquals(Chance.create((double) 1 /6), gettingThreeChanceInDice);
    }

    @Test
    @Description("Represent the chance with deMorgans law")
    void deMorgansTheorem() throws InvalidChanceArgument {
        Chance gettingTailInCoin1 = Chance.create(0.5);
        Chance gettingTailInCoin2 = Chance.create(0.5);

        Chance gettingTailInAnyOne = gettingTailInCoin1.deMorganLaw(gettingTailInCoin2);

        assertEquals(Chance.create(0.75), gettingTailInAnyOne);
    }

    @Test
    @Description("should throw on invalid chance")
    void shouldThrowOnInvalidChance() {
        assertThrows(InvalidChanceArgument.class, ()->Chance.create(2));
        assertThrows(InvalidChanceArgument.class, ()->Chance.create(-1));
    }
}
