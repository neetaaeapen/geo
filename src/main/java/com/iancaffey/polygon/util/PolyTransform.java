package com.iancaffey.polygon.util;

import com.iancaffey.polygon.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.function.Function;

/**
 * PolyTransform
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class PolyTransform {
    private PolyTransform() {

    }

    public static Function<DoublePoly, DoublePoly> doubleToRectilinear() {
        return poly -> {
            DoublePolyBuilder builder = new DoublePolyBuilder();
            for (int i = 0, length = poly.length() - 1; i < length; i += 2) {
                double x1 = poly.x(i);
                double x2 = poly.x(i + 1);
                double y1 = poly.y(i);
                double y2 = poly.y(i + 1);
                builder.add(x1, y1);
                if (x1 != x2 || y1 != y2)
                    builder.add(x2, y1);
                builder.add(x2, y2);
            }
            return builder.build();
        };
    }

    public static Function<IntPoly, IntPoly> intToRectilinear() {
        return poly -> {
            IntPolyBuilder builder = new IntPolyBuilder();
            for (int i = 0, length = poly.length() - 1; i < length; i += 2) {
                int x1 = poly.x(i);
                int x2 = poly.x(i + 1);
                int y1 = poly.y(i);
                int y2 = poly.y(i + 1);
                builder.add(x1, y1);
                if (x1 != x2 || y1 != y2)
                    builder.add(x2, y1);
                builder.add(x2, y2);
            }
            return builder.build();
        };
    }

    public static Function<LongPoly, LongPoly> longToRectilinear() {
        return poly -> {
            LongPolyBuilder builder = new LongPolyBuilder();
            for (int i = 0, length = poly.length() - 1; i < length; i += 2) {
                long x1 = poly.x(i);
                long x2 = poly.x(i + 1);
                long y1 = poly.y(i);
                long y2 = poly.y(i + 1);
                builder.add(x1, y1);
                if (x1 != x2 || y1 != y2)
                    builder.add(x2, y1);
                builder.add(x2, y2);
            }
            return builder.build();
        };
    }

    public static Function<ShortPoly, ShortPoly> shortToRectilinear() {
        return poly -> {
            ShortPolyBuilder builder = new ShortPolyBuilder();
            for (int i = 0, length = poly.length() - 1; i < length; i += 2) {
                short x1 = poly.x(i);
                short x2 = poly.x(i + 1);
                short y1 = poly.y(i);
                short y2 = poly.y(i + 1);
                builder.add(x1, y1);
                if (x1 != x2 || y1 != y2)
                    builder.add(x2, y1);
                builder.add(x2, y2);
            }
            return builder.build();
        };
    }

    public static Function<DoublePoly, BufferedImage> doubleToImage() {
        return doubleToImage(Color.BLACK);
    }

    public static Function<DoublePoly, BufferedImage> doubleToImage(Color color) {
        if (color == null)
            throw new IllegalArgumentException();
        final int rgb = color.getRGB();
        return poly -> {
            double maxX = 0;
            double maxY = 0;
            for (double[] i : poly) {
                if (i[0] > maxX)
                    maxX = i[0];
                if (i[1] > maxY)
                    maxY = i[1];
            }
            BufferedImage image = new BufferedImage((int) Math.round(maxX + 1), (int) Math.round(maxY + 1), BufferedImage.TYPE_INT_ARGB);
            for (double[] i : poly)
                image.setRGB((int) Math.round(i[0]), (int) Math.round(i[1]), rgb);
            return image;
        };
    }

    public static Function<IntPoly, BufferedImage> intToImage() {
        return intToImage(Color.BLACK);
    }

    public static Function<IntPoly, BufferedImage> intToImage(Color color) {
        if (color == null)
            throw new IllegalArgumentException();
        final int rgb = color.getRGB();
        return poly -> {
            int maxX = 0;
            int maxY = 0;
            for (int[] i : poly) {
                if (i[0] > maxX)
                    maxX = i[0];
                if (i[1] > maxY)
                    maxY = i[1];
            }
            BufferedImage image = new BufferedImage(maxX + 1, maxY + 1, BufferedImage.TYPE_INT_ARGB);
            for (int[] i : poly)
                image.setRGB(i[0], i[1], rgb);
            return image;
        };
    }

    public static Function<LongPoly, BufferedImage> longToImage() {
        return longToImage(Color.BLACK);
    }

    public static Function<LongPoly, BufferedImage> longToImage(Color color) {
        if (color == null)
            throw new IllegalArgumentException();
        final int rgb = color.getRGB();
        return poly -> {
            long maxX = 0;
            long maxY = 0;
            for (long[] i : poly) {
                if (i[0] > maxX)
                    maxX = i[0];
                if (i[1] > maxY)
                    maxY = i[1];
            }
            BufferedImage image = new BufferedImage((int) (maxX + 1), (int) (maxY + 1), BufferedImage.TYPE_INT_ARGB);
            for (long[] i : poly)
                image.setRGB((int) (i[0]), (int) (i[1]), rgb);
            return image;
        };
    }

    public static Function<ShortPoly, BufferedImage> shortToImage() {
        return shortToImage(Color.BLACK);
    }

    public static Function<ShortPoly, BufferedImage> shortToImage(Color color) {
        if (color == null)
            throw new IllegalArgumentException();
        final int rgb = color.getRGB();
        return poly -> {
            short maxX = 0;
            short maxY = 0;
            for (short[] i : poly) {
                if (i[0] > maxX)
                    maxX = i[0];
                if (i[1] > maxY)
                    maxY = i[1];
            }
            BufferedImage image = new BufferedImage(maxX + 1, maxY + 1, BufferedImage.TYPE_INT_ARGB);
            for (short[] i : poly)
                image.setRGB(i[0], i[1], rgb);
            return image;
        };
    }
}
