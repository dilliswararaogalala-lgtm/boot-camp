package com.bootcamp.tw.p2;

import jdk.jfr.Description;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FlipTest {

    @Test
    @Description("user should able to flip a coin and get the result of that flip")
    public void flipAndGettingResult() {
        Coin coin  = Mockito.mock(Coin.class);
        Mockito.when(coin.flip()).thenReturn(CoinType.HEAD);
        Probability probability = new Probability(coin);

        CoinType type = probability.flipCoin();
        assertEquals(CoinType.HEAD, type);
    }


    @Test
    @Description("user should able to flip a coin and get the probability of getting tail")
    public void flipAndGettingResultOfTail() {
        Coin coin  = Mockito.mock(Coin.class);
        Mockito.when(coin.flip()).thenReturn(CoinType.TAIL);
        Probability probability = new Probability(coin);

        CoinType type = probability.flipCoin();
        assertEquals(CoinType.TAIL, type);
        assertEquals(1, probability.getTailProbability());
    }

    @Test
    @Description("user should able to flip a coin and get the probability of not getting tail")
    public void flipAndNotGettingTail() {
        Coin coin  = Mockito.mock(Coin.class);
        Mockito.when(coin.flip()).thenReturn(CoinType.TAIL);
        Probability probability = new Probability(coin);

        CoinType type = probability.flipCoin();
        assertEquals(CoinType.TAIL, type);
        assertEquals(0, probability.getProbabilityOfNotGetting(CoinType.TAIL));
    }

}
