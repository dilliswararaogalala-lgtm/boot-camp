package com.bootcamp.tw.p2;

public class Coin {
    public CoinType flip() {
        if (Math.random() > 0.5){
            return CoinType.HEAD;
        }
        return CoinType.TAIL;
    }
}
