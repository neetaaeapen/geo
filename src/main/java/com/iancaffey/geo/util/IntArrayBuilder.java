package com.iancaffey.geo.util;

import java.util.ArrayList;
import java.util.List;

/**
 * IntArrayBuilder
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class IntArrayBuilder extends AbstractArrayBuilder<int[][]> {
    private final List<int[]> values = new ArrayList<>();

    public IntArrayBuilder(int dimension) {
        super(dimension);
    }

    public IntArrayBuilder add(int... values) {
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
