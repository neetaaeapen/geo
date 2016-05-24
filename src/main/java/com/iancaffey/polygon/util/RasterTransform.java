package com.iancaffey.polygon.util;

import java.awt.image.BufferedImage;
import java.util.function.Function;

/**
 * RasterTransform
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface RasterTransform {
    public static Function<BufferedImage, int[][]> toBuffer() {
        return RasterTransform::toBuffer;
    }

    public static Function<int[][], int[][]> toGrayscale(Grayscale grayscale) {
        return array -> toGrayscale(array, grayscale);
    }

    public static Function<int[][], BufferedImage> toImage() {
        return RasterTransform::toImage;
    }

    public static int[][] toBuffer(BufferedImage image) {
        if (image == null)
            throw new IllegalArgumentException();
        int[][] buffer = new int[image.getHeight()][image.getWidth()];
        for (int y = 0; y < buffer.length; y++)
            for (int x = 0; x < buffer[y].length; x++)
                buffer[y][x] = image.getRGB(x, y);
        return buffer;
    }

    public static int[][] toGrayscale(int[][] buffer, Grayscale grayscale) {
        if (buffer == null || grayscale == null)
            throw new IllegalArgumentException();
        for (int i = 0; i < buffer.length; i++)
            for (int j = 0; j < buffer[i].length; j++)
                buffer[i][j] = grayscale.convert((buffer[i][j] >> 16) & 0xFF, (buffer[i][j] >> 8) & 0xFF, buffer[i][j] & 0xFF, (buffer[i][j] >> 24) & 0xFF);
        return buffer;
    }

    public static BufferedImage toImage(int[][] buffer) {
        if (buffer == null)
            throw new IllegalArgumentException();
        BufferedImage image = new BufferedImage(buffer[0].length, buffer.length, BufferedImage.TYPE_INT_ARGB);
        for (int i = 0; i < buffer.length; i++)
            for (int j = 0; j < buffer[i].length; j++)
                image.setRGB(j, i, buffer[i][j]);
        return image;
    }
}
