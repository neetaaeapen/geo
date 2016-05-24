package com.iancaffey.polygon.util;

import com.iancaffey.polygon.IntPoly;

import java.awt.*;
import java.util.function.Function;

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

    public static Function<int[][], int[][]> grayscaleMatch(Color color) {
        return grayscaleMatch(color, VERY_PRECISE);
    }

    public static Function<int[][], int[][]> grayscaleMatch(Color color, double threshold) {
        if (color == null)
            throw new IllegalArgumentException();
        return grayscaleMatch(color.getRGB(), threshold);
    }

    public static Function<int[][], int[][]> grayscaleMatch(int rgb) {
        return grayscaleMatch(rgb, VERY_PRECISE);
    }

    public static Function<int[][], int[][]> grayscaleMatch(int rgb, double threshold) {
        if (threshold < 0 || threshold > 1)
            throw new IllegalArgumentException();
        return buffer -> {
            int black = Color.BLACK.getRGB();
            for (int y = 0; y < buffer.length; y++)
                for (int x = 0; x < buffer[y].length; x++)
                    buffer[y][x] = Math.abs((buffer[y][x] - rgb) / (double) black) < threshold ? black : 0;
            return buffer;
        };
    }

    public static Function<int[][], IntPoly> grayscaleMatchPoly(Color color) {
        return grayscaleMatchPoly(color, VERY_PRECISE);
    }

    public static Function<int[][], IntPoly> grayscaleMatchPoly(Color color, double threshold) {
        if (color == null)
            throw new IllegalArgumentException();
        return grayscaleMatchPoly(color.getRGB(), threshold);
    }

    public static Function<int[][], IntPoly> grayscaleMatchPoly(int rgb) {
        return grayscaleMatchPoly(rgb, VERY_PRECISE);
    }

    public static Function<int[][], IntPoly> grayscaleMatchPoly(int rgb, double threshold) {
        if (threshold < 0 || threshold > 1)
            throw new IllegalArgumentException();
        return buffer -> {
            boolean[][] checked = new boolean[buffer.length][buffer[0].length];
            int black = Color.BLACK.getRGB();
            int count = 0;
            for (int y = 0; y < buffer.length; y++)
                for (int x = 0; x < buffer[y].length; x++)
                    if (checked[y][x] = (Math.abs((buffer[y][x] - rgb) / (double) black) < threshold))
                        count++;
            int n = 0;
            int[] x = new int[count];
            int[] y = new int[count];
            for (int i = 0; i < checked.length; i++) {
                for (int j = 0; j < checked[i].length; j++) {
                    if (checked[i][j]) {
                        x[n] = j;
                        y[n++] = i;
                    }
                }
            }
            return new IntPoly(x, y, count);
        };
    }
}
