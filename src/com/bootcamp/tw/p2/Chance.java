package com.bootcamp.tw.p2;

import java.util.Objects;

public class Chance {
    private final double chance;

    public Chance(double chance) {
        this.chance = chance;
    }

    public static Chance create(double chance) throws InvlidChanceArgument {
        if (chance > 1.0 || chance < 0.0) {
            throw new InvlidChanceArgument("Invalid Chance Argument");
        }
        return new Chance(chance);
    }

    public static Chance create(double chance, double max) {
        return new Chance(chance / max);
    }

    public Chance compliment() throws InvlidChanceArgument {
        return Chance.create(1 - this.chance);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Chance chance1 = (Chance) o;
        return Double.compare(chance, chance1.chance) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(chance);
    }


    public Chance intersection(Chance chance2) throws InvlidChanceArgument {
        return Chance.create(this.chance * chance2.chance);
    }

    public Chance union(Chance chance2) throws InvlidChanceArgument {
        return Chance.create((this.chance + chance2.chance - this.intersection(chance2).chance));
    }

    public Chance deMorganLaw(Chance chance2) throws InvlidChanceArgument {
        Chance notOfChance1 = this.compliment();
        Chance notOfChance2 = chance2.compliment();

        return Chance.create(notOfChance1.intersection(notOfChance2).chance).compliment();
    }
}
