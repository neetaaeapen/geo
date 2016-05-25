package com.iancaffey.polygon.util;

import java.awt.image.BufferedImage;
import java.util.function.Function;
import java.util.stream.IntStream;

/**
 * RasterTransform
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface RasterTransform {
    public static Function<int[][], int[][]> apply(PixelTransform transform) {
        return array -> apply(array, transform);
    }

    public static int[][] toBuffer(BufferedImage image) {
        if (image == null)
            throw new IllegalArgumentException();
        int[][] buffer = new int[image.getHeight()][image.getWidth()];
        IntStream.range(0, buffer.length).forEach(i -> IntStream.range(0, buffer[i].length).forEach(j -> buffer[i][j] = image.getRGB(j, i)));
        return buffer;
    }

    public static int[][] apply(int[][] buffer, PixelTransform transform) {
        if (buffer == null || transform == null)
            throw new IllegalArgumentException();
        IntStream.range(0, buffer.length).forEach(i -> IntStream.range(0, buffer[i].length).forEach(j -> transform.apply(buffer[i][j])));
        return buffer;
    }

    public static BufferedImage toImage(int[][] buffer) {
        if (buffer == null)
            throw new IllegalArgumentException();
        BufferedImage image = new BufferedImage(buffer[0].length, buffer.length, BufferedImage.TYPE_INT_ARGB);
        IntStream.range(0, buffer.length).forEach(i -> IntStream.range(0, buffer[i].length).forEach(j -> image.setRGB(j, i, buffer[i][j])));
        return image;
    }
}
