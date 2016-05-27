package com.iancaffey.compute.transform;

import com.iancaffey.compute.util.DoubleMatrixBuilder;
import com.iancaffey.compute.util.IntMatrixBuilder;
import com.iancaffey.compute.util.LongMatrixBuilder;
import com.iancaffey.compute.util.ShortMatrixBuilder;

import java.util.Arrays;

/**
 * MatrixTransform
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class MatrixTransform {
    private MatrixTransform() {
    }

    public static double[][] toRectilinear(double[][] matrix) {
        if (matrix == null || matrix.length < 3 || matrix[0].length < 2)
            throw new IllegalArgumentException();
        DoubleMatrixBuilder builder = new DoubleMatrixBuilder(matrix[0].length);
        for (int i = 0, length = matrix.length - 1; i < length; i += 2) {
            double[] one = matrix[i];
            double[] two = matrix[i + 1];
            builder.add(one);
            if (!Arrays.equals(one, two)) {
                for (int j = 0; j < one.length; j++) {
                    //TODO:Figure out how to form point(s) to make rectilinear
                }
            }
            builder.add(two);
        }
        return builder.build();
    }

    public static int[][] toRectilinear(int[][] matrix) {
        if (matrix == null || matrix.length < 3 || matrix[0].length < 2)
            throw new IllegalArgumentException();
        IntMatrixBuilder builder = new IntMatrixBuilder(matrix[0].length);
        for (int i = 0, length = matrix.length - 1; i < length; i += 2) {
            int[] one = matrix[i];
            int[] two = matrix[i + 1];
            builder.add(one);
            if (!Arrays.equals(one, two)) {
                for (int j = 0; j < one.length; j++) {
                    //TODO:Figure out how to form point(s) to make rectilinear
                }
            }
            builder.add(two);
        }
        return builder.build();
    }

    public static long[][] toRectilinear(long[][] matrix) {
        if (matrix == null || matrix.length < 3 || matrix[0].length < 2)
            throw new IllegalArgumentException();
        LongMatrixBuilder builder = new LongMatrixBuilder(matrix[0].length);
        for (int i = 0, length = matrix.length - 1; i < length; i += 2) {
            long[] one = matrix[i];
            long[] two = matrix[i + 1];
            builder.add(one);
            if (!Arrays.equals(one, two)) {
                for (int j = 0; j < one.length; j++) {
                    //TODO:Figure out how to form point(s) to make rectilinear
                }
            }
            builder.add(two);
        }
        return builder.build();
    }

    public static short[][] toRectilinear(short[][] matrix) {
        if (matrix == null || matrix.length < 3 || matrix[0].length < 2)
            throw new IllegalArgumentException();
        ShortMatrixBuilder builder = new ShortMatrixBuilder(matrix[0].length);
        for (int i = 0, length = matrix.length - 1; i < length; i += 2) {
            short[] one = matrix[i];
            short[] two = matrix[i + 1];
            builder.add(one);
            if (!Arrays.equals(one, two)) {
                for (int j = 0; j < one.length; j++) {
                    //TODO:Figure out how to form point(s) to make rectilinear
                }
            }
            builder.add(two);
        }
        return builder.build();
    }
}
