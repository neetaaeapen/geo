package com.iancaffey.polygon.util;

import com.iancaffey.polygon.IntPoly;

import java.util.function.Function;

/**
 * ConvexHull
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface ConvexHull {
    public static Function<IntPoly, IntPoly> intGiftWrap() {
        return ConvexHull::giftWrap;
    }

    public static IntPoly giftWrap(IntPoly poly) {
        if (poly == null)
            throw new IllegalArgumentException();
        return poly;
    }
}
