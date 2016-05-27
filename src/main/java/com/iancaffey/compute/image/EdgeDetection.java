package com.iancaffey.compute.image;

import com.iancaffey.compute.util.IntArrayBuilder;

import java.awt.*;
import java.util.stream.IntStream;

/**
 * EdgeDetection
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class EdgeDetection {
    public static final double EXACT = 0;
    public static final double VERY_PRECISE = 0.0125;
    public static final double PRECISE = 0.25;
    public static final double MODERATE = 0.5;
    public static final double TOLERANT = 0.75;
    public static final double VERY_TOLERANT = 0.9125;
    public static final double ANY = 1;

    private EdgeDetection() {
    }

    public static int[][] grayscaleMatch(int[][] matrix, Color color, double threshold) {
        if (color == null)
            throw new IllegalArgumentException();
        return grayscaleMatch(matrix, color.getRGB(), threshold);
    }

    public static int[][] grayscaleMatch(int[][] matrix, int rgb, double threshold) {
        if (threshold < 0 || threshold > 1)
            throw new IllegalArgumentException();
        IntArrayBuilder builder = new IntArrayBuilder(2);
        IntStream.range(0, matrix.length).forEach(y -> IntStream.range(0, matrix[y].length)
                .filter(x -> Math.abs((matrix[y][x] - rgb) / (double) Color.BLACK.getRGB()) < threshold)
                .forEach(x -> builder.add(x, y)));
        return builder.build();
    }
}
