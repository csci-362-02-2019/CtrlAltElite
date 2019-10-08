package project;

/**
 * *****************************************************************************
 * Copyright (c) 2009, 2010, 2011, 2012, 2013, 2014, 2015, 2016, 2017, 2018 IBM
 * Corporation, BfR, and others. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse
 * Public License v2.0 which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors: IBM Corporation - initial API and implementation and new
 * features Bundesinstitut für Risikobewertung - Pajek Graph interface, new
 * Veterinary Models
 ******************************************************************************
 */

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Provides different mathematical methods.
 *
 */
public final class MathOps {

    private MathOps() {
        // do not instantiate
    }

    /**
     * Calculates the maximum entry of an array, where only specific indices are
     * allowed to be treated. Returns the index of the maximum.
     *
     * @param indices allowed indices to be checked for maximum
     * @param entries array, where maximum is taken from
     * @return index of the maximum of the entries array
     */
    public static int argMaxDouble(final double[] entries, final Collection<Integer> indices) {
        if (entries == null || entries.length == 0 || indices == null || indices.isEmpty()) {
            return -1;
        }

        final Iterator<Integer> itr = indices.iterator();
        int argmax = itr.next();

        while (itr.hasNext()) {
            final Integer element = itr.next();
            if (entries[element] > entries[argmax]) {
                argmax = element;
            }
        }
        return argmax;
    }

    /**
     * Calculates the minimum entry of an array, where only specific indices are
     * allowed to be treated. Returns the index of the minimum.
     *
     * @param indices allowed indices to be checked for minimum
     * @param entries array, where minimum is taken from
     * @return index of the minimum of the entries array
     */
    public static int argMinDouble(final double[] entries, final Collection<Integer> indices) {
        if (entries == null || entries.length == 0 || indices == null || indices.isEmpty()) {
            return -1;
        }

        final Iterator<Integer> itr = indices.iterator();
        int argmin = itr.next();

        while (itr.hasNext()) {
            final Integer element = itr.next();
            if (entries[element] < entries[argmin]) {
                argmin = element;
            }
        }
        return argmin;
    }

    /**
     * Greatest common divisor, coded by by Scot Drysdale, Dartmouth University.
     * See <a href=
     * "http://www.cs.dartmouth.edu/farid/teaching/cs15/cs5/lectures/0501/GCD.java"
     * >http://www.cs.dartmouth.edu/farid/teaching/cs15/cs5/lectures/0501/GCD.
     * java</a>
     *
     * @param arg0 first number
     * @param arg1 second number
     * @return greatest common divisor of the given numbers
     */
    public static int gcd(final int arg0, final int arg1) {
        int rest;
        int num0 = Math.abs(arg0);
        int num1 = Math.abs(arg1);

        do {
            rest = num0 % num1;
            num0 = num1;
            num1 = rest;
        } while (rest > 0);

        return num0;
    }

    /**
     * Least common multiple calculated by reducing the problem to GCD. See <a
     * href="http://en.wikipedia.org/wiki/Least_common_multiple">http://en.
     * wikipedia.org/wiki/Least_common_multiple</a>
     *
     * @param arg0 first number
     * @param arg1 second number
     * @return least common multiple of the given numbers
     */
    public static int lcm(final int arg0, final int arg1) {
        return Math.abs(arg0 * arg1) / MathOps.gcd(arg0, arg1);
    }

    public static double sumLogs(Collection<Double> log_values) {
        Iterator<Double> it = log_values.iterator();
        Double s = it.next();
        while (it.hasNext()) {
            Double k = it.next();
            Double x = Math.max(s, k);
            Double y = Math.min(s, k);
            double c = y - x;
            s = x + Math.log(1 + Math.exp(c));
        }
        return s;
    }
}
