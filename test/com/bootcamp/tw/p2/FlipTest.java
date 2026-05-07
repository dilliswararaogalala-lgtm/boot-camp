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
        CoinExperiment coinExperiment = new CoinExperiment(coin);

        CoinType type = coinExperiment.flipCoin();
        assertEquals(CoinType.HEAD, type);
    }


    @Test
    @Description("user should able to flip a coin and get the result of that flip")
    public void flipAndGettingResultOfTail() {
        Coin coin  = Mockito.mock(Coin.class);
        Mockito.when(coin.flip()).thenReturn(CoinType.TAIL);
        CoinExperiment coinExperiment = new CoinExperiment(coin);

        CoinType type = coinExperiment.flipCoin();
        assertEquals(CoinType.TAIL, type);
    }

}
