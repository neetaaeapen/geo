package com.iancaffey.compute.util;

import java.util.ArrayList;
import java.util.List;

/**
 * DoubleMatrixBuilder
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class DoubleMatrixBuilder extends AbstractMatrixBuilder<double[][]> {
    private final List<double[]> values = new ArrayList<>();

    public DoubleMatrixBuilder(int dimension) {
        super(dimension);
    }

    public DoubleMatrixBuilder add(double... values) {
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
