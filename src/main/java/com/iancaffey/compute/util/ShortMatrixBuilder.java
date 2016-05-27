package com.iancaffey.compute.util;

import java.util.ArrayList;
import java.util.List;

/**
 * ShortMatrixBuilder
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class ShortMatrixBuilder extends AbstractMatrixBuilder<short[][]> {
    private final List<short[]> values = new ArrayList<>();

    public ShortMatrixBuilder(int dimension) {
        super(dimension);
    }

    public ShortMatrixBuilder add(short... values) {
        if (values == null || values.length != dimension())
            throw new IllegalArgumentException();
        this.values.add(values);
        return this;
    }

    @Override
    public short[][] build() {
        if (values.size() < 3)
            throw new IllegalArgumentException();
        return values.toArray(new short[values.size()][]);
    }
}
