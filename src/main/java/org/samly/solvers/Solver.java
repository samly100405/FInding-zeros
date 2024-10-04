package org.samly.solvers;

import java.util.List;

public class Solver {
    private static final float EPSILON = 0.000001F;

    public static Result BisectionMethod(Polynomial f, List<Float> range, int maxIter) {
        if (range.size() != 2)
            throw new IllegalArgumentException("2 starting values for range");

        float a = range.get(0);
        float b = range.get(1);

        if (f.evaluate(a) * f.evaluate(b) >= 0)
            throw new IllegalArgumentException("Starting values must not be same sign");

        float c = (a + b) / 2;
        boolean converged = false;
        int iterations = 0;

        while (iterations < maxIter) {
            float fa = f.evaluate(a);
            float fc = f.evaluate(c);

            if (b - a < EPSILON || fc == 0) {
                converged = true;
                break;
            }

            if (fa * fc < 0) b = c;
            else             a = c;

            c = (a + b) / 2;
            iterations++;
        }

        return new Result(c, iterations, converged);
    }
}
