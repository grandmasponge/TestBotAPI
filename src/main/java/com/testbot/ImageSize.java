package com.testbot;

public enum ImageSize {
    SQUARE_48x48(48),
    SQUARE_144x144(144),
    SQUARE_240x240(240),
    SQUARE_480x480(480),
    SQUARE_720x720(720),
    SQUARE_1080x1080(1080);

    private final int size;

    private ImageSize(int size) {
        this.size = size;
    }

    final int getSize() {
        return this.size;
    }
}
