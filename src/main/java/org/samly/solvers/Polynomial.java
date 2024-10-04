package org.samly.solvers;

public final class Polynomial {
    private final int degree;
    private final float[] coefficients;

    public Polynomial(int degree, float[] coefficients) {
        this.degree = degree;
        this.coefficients = coefficients.clone();
    }

    public int getDegree() {
        return degree;
    }

    public float evaluate(float x) {
        float out = 0.0F;
        for (int i = 0; i < coefficients.length; i++) {
            out += (float) (coefficients[i] * Math.pow(x, degree-i));
        }
        return out;
    }
}