package com.bootcamp.tw.p2;
import java.util.ArrayList;

public class Probability <T> {
    private  final ArrayList<T> events;

    public Probability(ArrayList<T> events) {
        this.events = events;
    }

    public double getProbabilityOf(T currentType) {
        int count = 0;

        for (T type : events){
            if (currentType.equals(type) ){
                count += 1;
            }
        }
        return (double) count / events.size();
    }
}
