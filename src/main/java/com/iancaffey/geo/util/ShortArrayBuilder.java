package com.iancaffey.geo.util;

import java.util.ArrayList;
import java.util.List;

/**
 * ShortArrayBuilder
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class ShortArrayBuilder extends AbstractArrayBuilder<short[][]> {
    private final List<short[]> values = new ArrayList<>();

    public ShortArrayBuilder(int dimension) {
        super(dimension);
    }

    public ShortArrayBuilder add(short... values) {
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
