package com.iancaffey.geo.transform;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Arrays;

/**
 * PolyTransform
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class PolyTransform {
    private PolyTransform() {
    }

    public static BufferedImage toImage(double[][] poly) {
        return toImage(poly, Color.BLACK);
    }

    public static BufferedImage toImage(double[][] poly, Color color) {
        if (poly == null || poly.length == 0 || poly[0].length < 2 || color == null)
            throw new IllegalArgumentException();
        final int rgb = color.getRGB();
        final double[] max = {0, 0};
        Arrays.stream(poly).forEach(i -> {
            if (i[0] > max[0])
                max[0] = i[0];
            if (i[1] > max[1])
                max[1] = i[1];
        });
        BufferedImage image = new BufferedImage((int) Math.round(max[0] + 1), (int) Math.round(max[1] + 1), BufferedImage.TYPE_INT_ARGB);
        Arrays.stream(poly).forEach(i -> image.setRGB((int) Math.round(i[0]), (int) Math.round(i[1]), rgb));
        return image;
    }

    public static BufferedImage toImage(int[][] poly) {
        return toImage(poly, Color.BLACK);
    }

    public static BufferedImage toImage(int[][] poly, Color color) {
        if (poly == null || poly.length == 0 || poly[0].length < 2 || color == null)
            throw new IllegalArgumentException();
        final int rgb = color.getRGB();
        final int[] max = {0, 0};
        Arrays.stream(poly).forEach(i -> {
            if (i[0] > max[0])
                max[0] = i[0];
            if (i[1] > max[1])
                max[1] = i[1];
        });
        BufferedImage image = new BufferedImage(max[0] + 1, max[1] + 1, BufferedImage.TYPE_INT_ARGB);
        Arrays.stream(poly).forEach(i -> image.setRGB(i[0], i[1], rgb));
        return image;
    }

    public static BufferedImage toImage(long[][] poly) {
        return toImage(poly, Color.BLACK);
    }

    public static BufferedImage toImage(long[][] poly, Color color) {
        if (poly == null || poly.length == 0 || poly[0].length < 2 || color == null)
            throw new IllegalArgumentException();
        final int rgb = color.getRGB();
        final long[] max = {0, 0};
        Arrays.stream(poly).forEach(i -> {
            if (i[0] > max[0])
                max[0] = i[0];
            if (i[1] > max[1])
                max[1] = i[1];
        });
        BufferedImage image = new BufferedImage((int) (max[0] + 1), (int) (max[1] + 1), BufferedImage.TYPE_INT_ARGB);
        Arrays.stream(poly).forEach(i -> image.setRGB((int) (i[0]), (int) (i[1]), rgb));
        return image;
    }

    public static BufferedImage toImage(short[][] poly) {
        return toImage(poly, Color.BLACK);
    }

    public static BufferedImage toImage(short[][] poly, Color color) {
        if (poly == null || poly.length == 0 || poly[0].length < 2 || color == null)
            throw new IllegalArgumentException();
        final int rgb = color.getRGB();
        final short[] max = {0, 0};
        Arrays.stream(poly).forEach(i -> {
            if (i[0] > max[0])
                max[0] = i[0];
            if (i[1] > max[1])
                max[1] = i[1];
        });
        BufferedImage image = new BufferedImage(max[0] + 1, max[1] + 1, BufferedImage.TYPE_INT_ARGB);
        Arrays.stream(poly).forEach(i -> image.setRGB(i[0], i[1], rgb));
        return image;
    }
}
