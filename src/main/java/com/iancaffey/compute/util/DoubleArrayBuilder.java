package com.iancaffey.compute.util;

import java.util.ArrayList;
import java.util.List;

/**
 * DoubleArrayBuilder
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class DoubleArrayBuilder extends AbstractArrayBuilder<double[][]> {
    private final List<double[]> values = new ArrayList<>();

    public DoubleArrayBuilder(int dimension) {
        super(dimension);
    }

    public DoubleArrayBuilder add(double... values) {
        if (values == null || values.length != dimension())
            throw new IllegalArgumentException();
        this.values.add(values);
        return this;
    }

    @Override
    public double[][] build() {
        if (values.size() < 3)
            throw new IllegalArgumentException();
        return values.toArray(new double[values.size()][]);
    }
}
