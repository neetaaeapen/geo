package com.iancaffey.polygon;

/**
 * Poly
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface Poly {
    public ShortPoly asShortPoly();

    public IntPoly asIntPoly();

    public LongPoly asLongPoly();

    public DoublePoly asDoublePoly();

    public int length();
}
