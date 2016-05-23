package com.iancaffey.polygon;

import java.util.ArrayList;
import java.util.List;

/**
 * DoublePolyBuilder
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class DoublePolyBuilder implements PolyBuilder<DoublePoly> {
    private final List<Double> x = new ArrayList<>();
    private final List<Double> y = new ArrayList<>();

    public DoublePolyBuilder add(double x, double y) {
        this.x.add(x);
        this.y.add(y);
        return this;
    }

    @Override
    public DoublePoly build() {
        double[] x = new double[this.x.size()];
        double[] y = new double[x.length];
        for (int i = 0; i < x.length; i++) {
            x[i] = this.x.get(i);
            y[i] = this.y.get(i);
        }
        return new DoublePoly(x, y, x.length);
    }
}
