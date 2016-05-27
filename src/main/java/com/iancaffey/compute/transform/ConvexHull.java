package com.iancaffey.compute.transform;

import com.iancaffey.compute.util.IntArrayBuilder;

/**
 * ConvexHull
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class ConvexHull {
    private ConvexHull() {
    }

    public static int[][] giftWrap(int[][] poly) {
        if (poly == null || poly.length < 3)
            throw new IllegalArgumentException();
        IntArrayBuilder builder = new IntArrayBuilder(poly[0].length);

        return poly;
    }
}
