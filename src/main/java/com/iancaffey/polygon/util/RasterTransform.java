package com.iancaffey.polygon.util;

import java.awt.image.BufferedImage;
import java.util.function.Function;

/**
 * RasterTransform
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class RasterTransform {
    private RasterTransform() {

    }

    public static Function<BufferedImage, int[][]> toBuffer() {
        return image -> {
            int[][] buffer = new int[image.getHeight()][image.getWidth()];
            for (int y = 0; y < buffer.length; y++)
                for (int x = 0; x < buffer[y].length; x++)
                    buffer[y][x] = image.getRGB(x, y);
            return buffer;
        };
    }

    public static Function<int[][], int[][]> toGrayscale(Grayscale grayscale) {
        if (grayscale == null)
            throw new IllegalArgumentException();
        return array -> {
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    int r = (array[i][j] >> 16) & 0xFF;
                    int g = (array[i][j] >> 8) & 0xFF;
                    int b = array[i][j] & 0xFF;
                    int a = (array[i][j] >> 24) & 0xff;
                    array[i][j] = grayscale.convert(r, g, b, a);
                }
            }
            return array;
        };
    }

    public static Function<int[][], BufferedImage> toImage() {
        return array -> {
            BufferedImage image = new BufferedImage(array[0].length, array.length, BufferedImage.TYPE_INT_ARGB);
            for (int i = 0; i < array.length; i++)
                for (int j = 0; j < array[i].length; j++)
                    image.setRGB(j, i, array[i][j]);
            return image;
        };
    }
}
