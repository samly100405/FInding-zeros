package org.samly.solvers;

import java.util.List;

public class Solver {
    private static final float EPSILON = 1E-23F;
    private static final float DELTA = 0.000001F;
    private static final int HYBRID_BISECTION_COUNT = 5;

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

    public static Result NewtonsMethod(Polynomial f, List<Float> range, int maxIter) {
        if (range.size() != 1)
            throw new IllegalArgumentException("1 starting value");

        float a = range.get(0);
        Polynomial df = f.derivative();

        boolean converged = false;
        int iterations = 0;

        while (iterations < maxIter) {
            float vdf = df.evaluate(a);
            float vf = f.evaluate(a);

            float d = vf / vdf;

            if ((d < 0 ? -d : d) < EPSILON) {
                converged  = true;
                break;
            }

            a -= d;

            if ((vdf < 0 ? -vdf : vdf) < DELTA) {
                break;
            }

            iterations++;
        }

        return new Result(a, iterations, converged);
    }
    public static Result SecantMethod(Polynomial f, List<Float> range, int maxIter) {
        if (range.size() != 2)
            throw new IllegalArgumentException("2 starting values for range");

        float a = Math.min(range.get(0), range.get(1));
        float b = Math.max(range.get(0), range.get(1));

        boolean converged = false;
        int iterations = 0;

        while (iterations < maxIter) {
            float fa = f.evaluate(a);
            float fb = f.evaluate(b);

            float m = (fb - fa) / (b - a);
            float c = a - fa / m;

            if ((fa/m < 0 ? -fa/m : fa/m) < EPSILON) {
                converged  = true;
                break;
            }

            iterations++;
            if (c < a) {
                b = a;
                a = c;
            }
            else {
                a = b;
                b = c;
            }
        }

        return new Result(a, iterations, converged);
    }
    public static Result HybridMethod(Polynomial f, List<Float> range, int maxIter) {
        if (range.size() != 2)
            throw new IllegalArgumentException("2 starting values for range");

        float a = range.get(0);
        float b = range.get(1);

        boolean converged = false;
        int iterations = 0;

        // Bisection first
        for (int i = 0; i < HYBRID_BISECTION_COUNT; i++) {
            float c = (a + b) / 2;
            float fa = f.evaluate(a);
            float fc = f.evaluate(c);

            if (fa * fc < 0) b = c;
            else             a = c;

            iterations++;
        }

        while (iterations < maxIter) {
            float fa = f.evaluate(a);
            float fb = f.evaluate(b);

            float m = (fb - fa) / (b - a);
            float c = a - fa / m;

            if ((fa/m < 0 ? -fa/m : fa/m) < EPSILON) {
                converged  = true;
                break;
            }

            iterations++;
            if (c < a) {
                b = a;
                a = c;
            }
            else {
                a = b;
                b = c;
            }
        }

        return new Result(a, iterations, converged);
    }
}
