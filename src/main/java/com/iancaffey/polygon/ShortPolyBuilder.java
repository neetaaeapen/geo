package com.iancaffey.polygon;

import java.util.ArrayList;
import java.util.List;

/**
 * ShortPolyBuilder
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class ShortPolyBuilder implements PolyBuilder<ShortPoly> {
    private final List<Short> x = new ArrayList<>();
    private final List<Short> y = new ArrayList<>();

    public ShortPolyBuilder add(short x, short y) {
        this.x.add(x);
        this.y.add(y);
        return this;
    }

    @Override
    public ShortPoly build() {
        short[] x = new short[this.x.size()];
        short[] y = new short[x.length];
        for (int i = 0; i < x.length; i++) {
            x[i] = this.x.get(i);
            y[i] = this.y.get(i);
        }
        return new ShortPoly(x, y, x.length);
    }
}
