package com.bootcamp.tw.p2;

import jdk.jfr.Description;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class FlipTest {
    @Test
    @Description("user should able to flip a coin and get the probability of getting tail")
    public void flipAndGettingResultOfTail() {

        ArrayList<CoinType> coinSides = new ArrayList<>();
        coinSides.add(CoinType.TAIL);

        Probability<CoinType> probability = new Probability<>(coinSides);

        assertEquals(1, probability.getProbabilityOf(CoinType.TAIL));
    }

    @Test
    @Description("user should able to flip a coin and get the probability of getting tail")
    public void flipAndGettingResultOfNotGettingTail() {

        ArrayList<CoinType> coinSides = new ArrayList<>();
        coinSides.add(CoinType.TAIL);

        Probability<CoinType> probability = new Probability<>(coinSides);

        assertEquals(0, probability.getProbabilityOfNotGetting(CoinType.TAIL));
    }

}
