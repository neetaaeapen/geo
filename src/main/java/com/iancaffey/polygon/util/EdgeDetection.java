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
    public static final double ANY = 1;

    private EdgeDetection() {

    }

    public static Function<int[][], IntPoly> colorMatch(Color color) {
        return colorMatch(color, 0.25);
    }

    public static Function<int[][], IntPoly> colorMatch(Color color, double threshold) {
        if (color == null || threshold < 0 || threshold > 1)
            throw new IllegalArgumentException();
        final int rgb = color.getRGB();
        final int black = Color.BLACK.getRGB();
        return buffer -> {
            if (buffer == null)
                return null;
            boolean[][] checked = new boolean[buffer.length][buffer[0].length];
            int count = 0;
            int minX = -1;
            int minY = -1;
            int maxX = -1;
            int maxY = -1;
            for (int y = 0; y < buffer.length; y++) {
                for (int x = 0; x < buffer[y].length; x++) {
                    checked[y][x] = Math.abs((buffer[y][x] - rgb) / (double) black) < threshold;
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
