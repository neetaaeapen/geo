package com.iancaffey.geo.image;

/**
 * PixelTransform
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface PixelTransform {
    public int apply(int r, int g, int b, int a);

    public default int apply(int rgb) {
        return apply((rgb >> 16) & 0xFF, (rgb >> 8) & 0xFF, rgb & 0xFF, (rgb >> 24) & 0xFF);
    }
}
