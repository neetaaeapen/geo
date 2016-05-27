package com.iancaffey.compute.util;

/**
 * AbstractMatrixBuilder
 *
 * @author Ian Caffey
 * @since 1.0
 */
public abstract class AbstractMatrixBuilder<M> implements MatrixBuilder<M> {
    private final int dimension;

    protected AbstractMatrixBuilder(int dimension) {
        if (dimension < 1)
            throw new IllegalArgumentException();
        this.dimension = dimension;
    }

    @Override
    public int dimension() {
        return dimension;
    }
}
