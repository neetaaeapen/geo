package com.iancaffey.geo.transform;

import com.iancaffey.geo.util.IntArrayBuilder;

import java.util.stream.IntStream;

/**
 * EdgeDetection
 * <p>
 * Algorithms for detecting edges within a bitmap
 * Images are converted into <code>int[][]</code> bitmap to allow using such edge detection algorithms within RGB-space.
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class EdgeDetection {

    private EdgeDetection() {
    }

    /**
     * Detects similar colors of a two-dimensional bitmap that lie within a threshold of a base value.
     * All points, even isolated points, will be detected as edges.
     * Only use this algorithm if there is a clear edge denoted by a single color within the bitmap.
     *
     * @param matrix    the bitmap to inspect for edges
     * @param base      the base edge value
     * @param threshold the range of acceptable edge values (inclusive) from the base value
     * @return an <code>int[][]</code> denoting all valid edges of the matrix.
     */
    public static int[][] matchAll(int[][] matrix, int base, int threshold) {
        if (threshold < 0)
            throw new IllegalArgumentException();
        IntArrayBuilder builder = new IntArrayBuilder(2);
        IntStream.range(0, matrix.length).forEach(y -> IntStream.range(0, matrix[y].length)
                .filter(x -> Math.abs(matrix[y][x] - base) <= threshold)
                .forEach(x -> builder.add(x, y)));
        return builder.build();
    }
}
