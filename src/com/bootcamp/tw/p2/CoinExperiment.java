package com.bootcamp.tw.p2;

public class CoinExperiment {
    private final Coin coin;

    public CoinExperiment(Coin coin) {
        this.coin = coin;
    }

    public CoinType flipCoin() {
        return this.coin.flip();
    }
}
