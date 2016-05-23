package com.iancaffey.polygon;

/**
 * AbstractPoly
 *
 * @author Ian Caffey
 * @since 1.0
 */
public abstract class AbstractPoly implements Poly {
    private final int length;

    protected AbstractPoly(int length) {
        if (length < 3)
            throw new IllegalArgumentException();
        this.length = length;
    }

    @Override
    public int length() {
        return length;
    }
}
