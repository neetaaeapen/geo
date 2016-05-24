package com.iancaffey.polygon;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * IntPoly
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class IntPoly extends AbstractPoly implements Iterable<int[]> {
    private final int[] x;
    private final int[] y;

    public IntPoly(int[] x, int[] y, int length) {
        super(length);
        this.x = x;
        this.y = y;
    }

    public int x(int index) {
        return x[index];
    }

    public void x(int index, int value) {
        x[index] = value;
    }

    public int y(int index) {
        return y[index];
    }

    public void y(int index, int value) {
        y[index] = value;
    }

    public int[] x() {
        return x;
    }

    public int[] y() {
        return y;
    }

    public IntPoly translate(int dx, int dy) {
        for (int i = 0; i < length(); i++) {
            x[i] += dx;
            y[i] += dy;
        }
        return this;
    }

    public Stream<int[]> stream() {
        return StreamSupport.stream(spliterator(), false);
    }

    public Stream<int[]> parallelStream() {
        return StreamSupport.stream(spliterator(), true);
    }

    @Override
    public ShortPoly asShortPoly() {
        int length = length();
        short[] x = new short[length];
        short[] y = new short[length];
        for (int i = 0; i < length; i++) {
            x[i] = (short) x(i);
            y[i] = (short) y(i);
        }
        return new ShortPoly(x, y, length);
    }

    @Override
    public IntPoly asIntPoly() {
        int length = length();
        return new IntPoly(Arrays.copyOf(x(), length), Arrays.copyOf(y(), length), length);
    }

    @Override
    public LongPoly asLongPoly() {
        int length = length();
        long[] x = new long[length];
        long[] y = new long[length];
        for (int i = 0; i < length; i++) {
            x[i] = (long) x(i);
            y[i] = (long) y(i);
        }
        return new LongPoly(x, y, length);
    }

    @Override
    public DoublePoly asDoublePoly() {
        int length = length();
        double[] x = new double[length];
        double[] y = new double[length];
        for (int i = 0; i < length; i++) {
            x[i] = (double) x(i);
            y[i] = (double) y(i);
        }
        return new DoublePoly(x, y, length);
    }

    @Override
    public Iterator<int[]> iterator() {
        return new Iterator<int[]>() {
            final int[] buffer = new int[2];
            int index = 0;
            int length = length();

            @Override
            public boolean hasNext() {
                return index < length;
            }

            @Override
            public int[] next() {
                if (!hasNext())
                    throw new NoSuchElementException();
                buffer[0] = x(index);
                buffer[1] = y(index++);
                return buffer;
            }
        };
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(getClass().getCanonicalName());
        builder.append('[');
        int length = length();
        for (int i = 0; i < length; i++)
            builder.append('[').append(x[i]).append(',').append(y[i]).append(']');
        builder.append(']');
        return builder.toString();
    }
}
