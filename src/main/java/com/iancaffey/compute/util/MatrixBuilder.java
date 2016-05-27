package com.iancaffey.compute.util;

/**
 * MatrixBuilder
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface MatrixBuilder<M> {
    public int dimension();

    public M build();
}
