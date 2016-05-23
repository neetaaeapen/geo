package com.iancaffey.polygon;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * DoublePoly
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class DoublePoly extends AbstractPoly implements Iterable<double[]> {
    private final double[] x;
    private final double[] y;

    public DoublePoly(double[] x, double[] y, int length) {
        super(length);
        this.x = x;
        this.y = y;
    }

    public double x(int index) {
        return x[index];
    }

    public void x(int index, double value) {
        x[index] = value;
    }

    public double y(int index) {
        return y[index];
    }

    public void y(int index, double value) {
        y[index] = value;
    }

    public double[] x() {
        return x;
    }

    public double[] y() {
        return y;
    }

    public Stream<double[]> stream() {
        return StreamSupport.stream(spliterator(), false);
    }

    public Stream<double[]> parallelStream() {
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
        int[] x = new int[length];
        int[] y = new int[length];
        for (int i = 0; i < length; i++) {
            x[i] = (int) x(i);
            y[i] = (int) y(i);
        }
        return new IntPoly(x, y, length);
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
        return new DoublePoly(Arrays.copyOf(x(), length), Arrays.copyOf(y(), length), length);
    }

    @Override
    public Iterator<double[]> iterator() {
        return new Iterator<double[]>() {
            final double[] buffer = new double[2];
            int index = 0;
            int length = length();

            @Override
            public boolean hasNext() {
                return index < length;
            }

            @Override
            public double[] next() {
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
