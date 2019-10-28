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
    
    public static final double MACHINE_EPSILON = MathOps.calculateMachineEpsilon();

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
    
        /**
     * Machine epsilon. For further information see <a
     * href="http://en.wikipedia.org/wiki/Machine_epsilon"
     * >http://en.wikipedia.org/wiki/Machine_epsilon</a>.
     *
     * @return machine epsilon
     */
    public static double calculateMachineEpsilon() {
        double machEps = 1.0d;
        do {
            machEps /= 2.0d;
        } while ((1.0 + (machEps / 2.0)) != 1.0);
        return machEps;
    
    /**
     * Double values are not precise due to the way they are stored (See IEEE
     * 754). In order to compare doubles, one has to approximate the equation
     * using a certain threshold. This method provides double comparison with
     * using a reasonable threshold.
     *
     * @param dbl1 Double value
     * @param dbl2 Double value
     * @return true if values are equal up to a certain threshold
     */
    public static boolean approxEqual(final double dbl1, final double dbl2) {
        return Math.abs(dbl1 - dbl2) <= MathOps.MACHINE_EPSILON;
    }
}
