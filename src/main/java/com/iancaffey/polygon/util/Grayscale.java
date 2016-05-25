package com.iancaffey.polygon.util;

/**
 * Grayscale
 *
 * @author Ian Caffey
 * @since 1.0
 */
public enum Grayscale implements PixelTransform {
    AVERAGE {
        @Override
        public int apply(int r, int g, int b, int a) {
            int sum = (r + g + b) / 3;
            return ((a & 0xFF) << 24) | ((sum & 0xFF) << 16) | ((sum & 0xFF) << 8) | ((sum & 0xFF));
        }
    },
    LIGHTNESS {
        @Override
        public int apply(int r, int g, int b, int a) {
            int sum = (Math.max(Math.max(r, g), b) + Math.min(Math.min(r, g), b)) / 2;
            return ((a & 0xFF) << 24) | ((sum & 0xFF) << 16) | ((sum & 0xFF) << 8) | ((sum & 0xFF));
        }
    },
    LUMINOSITY {
        @Override
        public int apply(int r, int g, int b, int a) {
            int sum = (int) Math.round(0.21 * r + 0.72 * g + 0.07 * b);
            return ((a & 0xFF) << 24) | ((sum & 0xFF) << 16) | ((sum & 0xFF) << 8) | ((sum & 0xFF));
        }
    };
}
