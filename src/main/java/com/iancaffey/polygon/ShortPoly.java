package com.iancaffey.polygon;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * ShortPoly
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class ShortPoly extends AbstractPoly implements Iterable<short[]> {
    private final short[] x;
    private final short[] y;

    public ShortPoly(short[] x, short[] y, int length) {
        super(length);
        this.x = x;
        this.y = y;
    }

    public short x(int index) {
        return x[index];
    }

    public void x(int index, short value) {
        x[index] = value;
    }

    public short y(int index) {
        return y[index];
    }

    public void y(int index, short value) {
        y[index] = value;
    }

    public short[] x() {
        return x;
    }

    public short[] y() {
        return y;
    }

    public Stream<short[]> stream() {
        return StreamSupport.stream(spliterator(), false);
    }

    public Stream<short[]> parallelStream() {
        return StreamSupport.stream(spliterator(), true);
    }

    @Override
    public ShortPoly asShortPoly() {
        int length = length();
        return new ShortPoly(Arrays.copyOf(x(), length), Arrays.copyOf(y(), length), length);
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
        double[] x = new double[length];
        double[] y = new double[length];
        for (int i = 0; i < length; i++) {
            x[i] = (double) x(i);
            y[i] = (double) y(i);
        }
        return new DoublePoly(x, y, length);
    }

    @Override
    public Iterator<short[]> iterator() {
        return new Iterator<short[]>() {
            final short[] buffer = new short[2];
            int index = 0;
            int length = length();

            @Override
            public boolean hasNext() {
                return index < length;
            }

            @Override
            public short[] next() {
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
