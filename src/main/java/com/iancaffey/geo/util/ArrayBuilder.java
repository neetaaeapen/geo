package com.iancaffey.geo.util;

/**
 * ArrayBuilder
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface ArrayBuilder<M> {
    public int dimension();

    public M build();
}
