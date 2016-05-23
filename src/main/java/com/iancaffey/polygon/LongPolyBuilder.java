package com.iancaffey.polygon;

import java.util.ArrayList;
import java.util.List;

/**
 * LongPolyBuilder
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class LongPolyBuilder implements PolyBuilder<LongPoly> {
    private final List<Long> x = new ArrayList<>();
    private final List<Long> y = new ArrayList<>();

    public LongPolyBuilder add(long x, long y) {
        this.x.add(x);
        this.y.add(y);
        return this;
    }

    @Override
    public LongPoly build() {
        long[] x = new long[this.x.size()];
        long[] y = new long[x.length];
        for (int i = 0; i < x.length; i++) {
            x[i] = this.x.get(i);
            y[i] = this.y.get(i);
        }
        return new LongPoly(x, y, x.length);
    }
}
