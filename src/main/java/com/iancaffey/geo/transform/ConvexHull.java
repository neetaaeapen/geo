package com.iancaffey.geo.transform;

import com.iancaffey.geo.util.IntArrayBuilder;

/**
 * ConvexHull
 * <p>
 * Algorithms for hulling n-dimensional polyhedrons.
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class ConvexHull {
    private ConvexHull() {
    }

    /**
     * Jarvis March
     * @param poly
     * @return
     */
    public static int[][] giftWrap(int[][] poly) {
        if (poly == null || poly.length < 3)
            throw new IllegalArgumentException();
        IntArrayBuilder builder = new IntArrayBuilder(poly[0].length);

        return poly;
    }
}
