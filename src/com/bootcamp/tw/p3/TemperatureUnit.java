package com.bootcamp.tw.p3;
import java.util.function.UnaryOperator;

public enum TemperatureUnit {
    CELSIUS ((c )-> c),
    FAHRENHEIT ((f) -> (f - 32) * (5.0 / 9)),
    STANDARD ((c) -> c);

    private final UnaryOperator<Double> formulaToStandard;

    TemperatureUnit(UnaryOperator<Double> formulaToStandard) {
        this.formulaToStandard = formulaToStandard;
    }

    public double toStandard(double unitValue) {
        return this.formulaToStandard.apply(unitValue);
    }
}
