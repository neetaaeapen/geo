package com.iancaffey.polygon.util;

import com.iancaffey.polygon.*;

import java.util.function.Function;

/**
 * PolyTransform
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class PolyTransform {
    private PolyTransform() {

    }

    public static Function<DoublePoly, DoublePoly> doubleToRectilinear() {
        return poly -> {
            DoublePolyBuilder builder = new DoublePolyBuilder();
            for (int i = 0, length = poly.length() - 1; i < length; i += 2) {
                double x1 = poly.x(i);
                double x2 = poly.x(i + 1);
                double y1 = poly.y(i);
                double y2 = poly.y(i + 1);
                builder.add(x1, y1);
                if (x1 != x2 || y1 != y2)
                    builder.add(x2, y1);
                builder.add(x2, y2);
            }
            return builder.build();
        };
    }

    public static Function<IntPoly, IntPoly> intToRectilinear() {
        return poly -> {
            IntPolyBuilder builder = new IntPolyBuilder();
            for (int i = 0, length = poly.length() - 1; i < length; i += 2) {
                int x1 = poly.x(i);
                int x2 = poly.x(i + 1);
                int y1 = poly.y(i);
                int y2 = poly.y(i + 1);
                builder.add(x1, y1);
                if (x1 != x2 || y1 != y2)
                    builder.add(x2, y1);
                builder.add(x2, y2);
            }
            return builder.build();
        };
    }

    public static Function<LongPoly, LongPoly> longToRectilinear() {
        return poly -> {
            LongPolyBuilder builder = new LongPolyBuilder();
            for (int i = 0, length = poly.length() - 1; i < length; i += 2) {
                long x1 = poly.x(i);
                long x2 = poly.x(i + 1);
                long y1 = poly.y(i);
                long y2 = poly.y(i + 1);
                builder.add(x1, y1);
                if (x1 != x2 || y1 != y2)
                    builder.add(x2, y1);
                builder.add(x2, y2);
            }
            return builder.build();
        };
    }

    public static Function<ShortPoly, ShortPoly> shortToRectilinear() {
        return poly -> {
            ShortPolyBuilder builder = new ShortPolyBuilder();
            for (int i = 0, length = poly.length() - 1; i < length; i += 2) {
                short x1 = poly.x(i);
                short x2 = poly.x(i + 1);
                short y1 = poly.y(i);
                short y2 = poly.y(i + 1);
                builder.add(x1, y1);
                if (x1 != x2 || y1 != y2)
                    builder.add(x2, y1);
                builder.add(x2, y2);
            }
            return builder.build();
        };
    }

}
