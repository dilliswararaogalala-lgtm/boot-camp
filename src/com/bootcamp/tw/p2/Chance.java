package com.bootcamp.tw.p2;

import java.util.Objects;

public class Chance {

    private final double chance;
    private final double min;
    private final double max;

    public Chance(double chance, double min, double max  ) {
        this.chance = chance;
        this.min = min;
        this.max = max;
    }

    public static Chance create(double chance) {
        return new Chance(chance, 0, 1);
    }

    public static Chance create(double chance, double max) {
        return new Chance(chance, 0, max);
    }

    public static Chance create(double chance,double min, double max) {
        return new Chance(chance, min, max);
    }

    public double getChance() {
        return this.chance;
    }

    public Chance not() {
        return Chance.create(max - this.chance + min , min, max);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Chance chance1 = (Chance) o;
        return Double.compare(chance, chance1.chance) == 0 && Double.compare(min, chance1.min) == 0 && Double.compare(max, chance1.max) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(chance, min, max);
    }

    public Chance intersection(Chance chance2) {
        return Chance.create(this.chance * chance2.chance, min, max);
    }

    public Chance union(Chance chance2) {
        Chance notOfChance1 = this.not();
        Chance notOfChance2 = chance2.not();
        return Chance.create(notOfChance1.chance * notOfChance2.chance, min, max).not();
    }
}
