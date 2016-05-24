package com.iancaffey.polygon.util;

import com.iancaffey.polygon.IntPoly;

/**
 * ConvexHull
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface ConvexHull {
    public static IntPoly giftWrap(IntPoly poly) {
        if (poly == null)
            throw new IllegalArgumentException();
        return poly;
    }
}
