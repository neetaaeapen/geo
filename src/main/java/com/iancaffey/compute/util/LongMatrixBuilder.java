package com.iancaffey.compute.util;

import java.util.ArrayList;
import java.util.List;

/**
 * LongMatrixBuilder
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class LongMatrixBuilder extends AbstractMatrixBuilder<long[][]> {
    private final List<long[]> values = new ArrayList<>();

    public LongMatrixBuilder(int dimension) {
        super(dimension);
    }

    public LongMatrixBuilder add(long... values) {
        if (values == null || values.length != dimension())
            throw new IllegalArgumentException();
        this.values.add(values);
        return this;
    }

    @Override
    public long[][] build() {
        return values.toArray(new long[values.size()][]);
    }
}
