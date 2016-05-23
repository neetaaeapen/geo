package com.iancaffey.polygon;

import java.util.ArrayList;
import java.util.List;

/**
 * IntPolyBuilder
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class IntPolyBuilder implements PolyBuilder<IntPoly> {
    private final List<Integer> x = new ArrayList<>();
    private final List<Integer> y = new ArrayList<>();

    public IntPolyBuilder add(int x, int y) {
        this.x.add(x);
        this.y.add(y);
        return this;
    }

    @Override
    public IntPoly build() {
        int[] x = new int[this.x.size()];
        int[] y = new int[x.length];
        for (int i = 0; i < x.length; i++) {
            x[i] = this.x.get(i);
            y[i] = this.y.get(i);
        }
        return new IntPoly(x, y, x.length);
    }
}
