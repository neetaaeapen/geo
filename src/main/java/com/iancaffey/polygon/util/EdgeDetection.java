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
    public static final double VERY_LOW = 0.0125;
    public static final double LOW = 0.25;
    public static final double MEDIUM = 0.5;
    public static final double HIGH = 0.75;
    public static final double VERY_HIGH = 0.9125;
    public static final double ANY = 1;

    private EdgeDetection() {

    }

    public static Function<int[][], IntPoly> colorMatch(Color color) {
        return colorMatch(color, LOW);
    }

    public static Function<int[][], IntPoly> colorMatch(Color color, double threshold) {
        if (color == null || threshold < 0 || threshold > 1)
            throw new IllegalArgumentException();
        return buffer -> {
            boolean[][] checked = new boolean[buffer.length][buffer[0].length];
            int count = 0;
            int minX = -1;
            int minY = -1;
            int maxX = -1;
            int maxY = -1;
            for (int y = 0; y < buffer.length; y++) {
                for (int x = 0; x < buffer[y].length; x++) {
                    checked[y][x] = Math.abs((buffer[y][x] - color.getRGB()) / (double) Color.BLACK.getRGB()) < threshold;
                    if (checked[y][x]) {
                        count++;
                        if (minX == -1 || x < minX)
                            minX = x;
                        if (minY == -1 || y < minY)
                            minY = y;
                        if (maxX == -1 || x > maxX)
                            maxX = x;
                        if (maxY == -1 || y > maxY)
                            maxY = y;
                    }
                }
            }
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
