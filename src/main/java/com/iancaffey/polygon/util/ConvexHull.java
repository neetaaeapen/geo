package com.iancaffey.polygon.util;

import com.iancaffey.polygon.IntPoly;

import java.util.function.Function;

/**
 * ConvexHull
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class ConvexHull {
    private ConvexHull() {

    }

    public static Function<IntPoly, IntPoly> intGiftWrap() {
        return poly -> {

            return poly;
        };
    }

}
