package com.github.martapietka.ppm2pbm;

public class Header {

    private int width;
    private int height;
    private int colourDepth;

    public Header(int width, int height, int colourDepth) {
        this.width = width;
        this.height = height;
        this.colourDepth = colourDepth;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getColourDepth() {
        return colourDepth;
    }
}
