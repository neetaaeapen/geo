package com.iancaffey.compute.image;

import java.awt.image.BufferedImage;
import java.util.stream.IntStream;

/**
 * RasterTransform
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class RasterTransform {
    private RasterTransform() {
    }

    public static int[][] toMatrix(BufferedImage image) {
        if (image == null)
            throw new IllegalArgumentException();
        int width = image.getWidth();
        int height = image.getHeight();
        int[][] matrix = new int[height][width];
        IntStream.range(0, matrix.length).forEach(i -> IntStream.range(0, matrix[i].length).forEach(j -> matrix[i][j] = image.getRGB(j, i)));
        return matrix;
    }

    public static int[][] apply(int[][] matrix, PixelTransform transform) {
        if (matrix == null || transform == null)
            throw new IllegalArgumentException();
        IntStream.range(0, matrix.length).forEach(i -> IntStream.range(0, matrix[i].length).forEach(j -> transform.apply(matrix[i][j])));
        return matrix;
    }

    public static BufferedImage toImage(int[][] matrix) {
        return toImage(matrix, BufferedImage.TYPE_INT_ARGB);
    }

    public static BufferedImage toImage(int[][] matrix, int imageType) {
        if (matrix == null)
            throw new IllegalArgumentException();
        BufferedImage image = new BufferedImage(matrix[0].length, matrix.length, imageType);
        IntStream.range(0, matrix.length).forEach(i -> IntStream.range(0, matrix[i].length).forEach(j -> image.setRGB(j, i, matrix[i][j])));
        return image;
    }
}
