package com.iancaffey.geo.util;

import java.util.ArrayList;
import java.util.List;

/**
 * LongArrayBuilder
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class LongArrayBuilder extends AbstractArrayBuilder<long[][]> {
    private final List<long[]> values = new ArrayList<>();

    public LongArrayBuilder(int dimension) {
        super(dimension);
    }

    public LongArrayBuilder add(long... values) {
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
