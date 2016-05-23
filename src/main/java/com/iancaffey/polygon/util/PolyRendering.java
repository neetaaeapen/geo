package com.iancaffey.polygon.util;

import com.iancaffey.polygon.DoublePoly;
import com.iancaffey.polygon.IntPoly;
import com.iancaffey.polygon.LongPoly;
import com.iancaffey.polygon.ShortPoly;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.function.Function;

/**
 * PolyRendering
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class PolyRendering {
    private PolyRendering() {

    }

    public static Function<BufferedImage, int[][]> buffer() {
        return image -> {
            int[][] buffer = new int[image.getHeight()][image.getWidth()];
            for (int y = 0; y < buffer.length; y++)
                for (int x = 0; x < buffer[y].length; x++)
                    buffer[y][x] = image.getRGB(x, y);
            return buffer;
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
            double minX = 0;
            double minY = 0;
            double maxX = 0;
            double maxY = 0;
            for (double[] i : poly) {
                if (i[0] < minX)
                    minX = i[0];
                if (i[0] > maxX)
                    maxX = i[0];
                if (i[1] < minY)
                    minY = i[1];
                if (i[1] > maxY)
                    maxY = i[1];
            }
            BufferedImage image = new BufferedImage((int) Math.round(maxX - minX + 1), (int) Math.round(maxY - minY + 1), BufferedImage.TYPE_INT_ARGB);
            for (double[] i : poly)
                image.setRGB((int) Math.round(i[0] - minX), (int) Math.round(i[1] - minY), rgb);
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
            int minX = 0;
            int minY = 0;
            int maxX = 0;
            int maxY = 0;
            for (int[] i : poly) {
                if (i[0] < minX)
                    minX = i[0];
                if (i[0] > maxX)
                    maxX = i[0];
                if (i[1] < minY)
                    minY = i[1];
                if (i[1] > maxY)
                    maxY = i[1];
            }
            BufferedImage image = new BufferedImage(maxX - minX + 1, maxY - minY + 1, BufferedImage.TYPE_INT_ARGB);
            for (int[] i : poly)
                image.setRGB(i[0] - minX, i[1] - minY, rgb);
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
            long minX = 0;
            long minY = 0;
            long maxX = 0;
            long maxY = 0;
            for (long[] i : poly) {
                if (i[0] < minX)
                    minX = i[0];
                if (i[0] > maxX)
                    maxX = i[0];
                if (i[1] < minY)
                    minY = i[1];
                if (i[1] > maxY)
                    maxY = i[1];
            }
            BufferedImage image = new BufferedImage((int) (maxX - minX + 1), (int) (maxY - minY + 1), BufferedImage.TYPE_INT_ARGB);
            for (long[] i : poly)
                image.setRGB((int) (i[0] - minX), (int) (i[1] - minY), rgb);
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
            short minX = 0;
            short minY = 0;
            short maxX = 0;
            short maxY = 0;
            for (short[] i : poly) {
                if (i[0] < minX)
                    minX = i[0];
                if (i[0] > maxX)
                    maxX = i[0];
                if (i[1] < minY)
                    minY = i[1];
                if (i[1] > maxY)
                    maxY = i[1];
            }
            BufferedImage image = new BufferedImage(maxX - minX + 1, maxY - minY + 1, BufferedImage.TYPE_INT_ARGB);
            for (short[] i : poly)
                image.setRGB(i[0] - minX, i[1] - minY, rgb);
            return image;
        };
    }
}
