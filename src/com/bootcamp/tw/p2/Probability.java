package com.bootcamp.tw.p2;
import java.util.ArrayList;

public class Probability {
    private final Coin coin;
    private final ArrayList<CoinType> results = new ArrayList<>();

    public Probability(Coin coin) {
        this.coin = coin;
    }

    public CoinType flipCoin() {
        CoinType result = this.coin.flip();
        results.add(result);
        return result;
    }

    public double getTailProbability() {
        int count = 0;
        for (CoinType type : results){
            if (CoinType.TAIL.equals(type) ){
                count += 1;
            }
        }
        return (double) count / results.size();
    }


    public double getProbabilityOfNotGetting(CoinType type) {
        return 1 - getTailProbability(type);
    }

    private double getTailProbability(CoinType coinType) {
        int count = 0;
        for (CoinType type : results){
            if (coinType.equals(type) ){
                count += 1;
            }
        }
        return (double) count / results.size();
    }
}
