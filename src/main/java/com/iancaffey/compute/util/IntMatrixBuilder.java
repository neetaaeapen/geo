package com.iancaffey.compute.util;

import java.util.ArrayList;
import java.util.List;

/**
 * IntMatrixBuilder
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class IntMatrixBuilder extends AbstractMatrixBuilder<int[][]> {
    private final List<int[]> values = new ArrayList<>();

    public IntMatrixBuilder(int dimension) {
        super(dimension);
    }

    public IntMatrixBuilder add(int... values) {
        if (values == null || values.length != dimension())
            throw new IllegalArgumentException();
        this.values.add(values);
        return this;
    }

    @Override
    public int[][] build() {
        if (values.size() < 3)
            throw new IllegalArgumentException();
        return values.toArray(new int[values.size()][]);
    }
}
