package com.iancaffey.compute.util;

/**
 * AbstractArrayBuilder
 *
 * @author Ian Caffey
 * @since 1.0
 */
public abstract class AbstractArrayBuilder<M> implements ArrayBuilder<M> {
    private final int dimension;

    protected AbstractArrayBuilder(int dimension) {
        if (dimension < 1)
            throw new IllegalArgumentException();
        this.dimension = dimension;
    }

    @Override
    public int dimension() {
        return dimension;
    }
}
