package com.bootcamp.tw.p3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CompareTemperatureTest {
    @Test
    void compareFahrenheitAndCelsius() {
        Temperature fahrenheit = Temperature.create(212, TemperatureUnit.FAHRENHEIT);
        Temperature celsius = Temperature.create(100, TemperatureUnit.CELSIUS);
        assertEquals(fahrenheit, celsius);

    }
}
