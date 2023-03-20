package com.github.martapietka.ppm2pbm;

public class PpmConverterStrategy {

    private Strategy strategy;

    public PpmConverterStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public int convertRgbToGrayscale(int r, int g, int b) {
        return strategy.convertRgbToGrayscale(r, g, b);
    }

}
