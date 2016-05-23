package com.iancaffey.polygon;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * LongPoly
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class LongPoly extends AbstractPoly implements Iterable<long[]> {
    private final long[] x;
    private final long[] y;

    public LongPoly(long[] x, long[] y, int length) {
        super(length);
        this.x = x;
        this.y = y;
    }

    public long x(int index) {
        return x[index];
    }

    public void x(int index, long value) {
        x[index] = value;
    }

    public long y(int index) {
        return y[index];
    }

    public void y(int index, long value) {
        y[index] = value;
    }

    public long[] x() {
        return x;
    }

    public long[] y() {
        return y;
    }

    public Stream<long[]> stream() {
        return StreamSupport.stream(spliterator(), false);
    }

    public Stream<long[]> parallelStream() {
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
        return new LongPoly(Arrays.copyOf(x(), length), Arrays.copyOf(y(), length), length);
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
    public Iterator<long[]> iterator() {
        return new Iterator<long[]>() {
            final long[] buffer = new long[2];
            int index = 0;
            int length = length();

            @Override
            public boolean hasNext() {
                return index < length;
            }

            @Override
            public long[] next() {
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
