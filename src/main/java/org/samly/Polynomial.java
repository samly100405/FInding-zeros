package org.samly;

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

    public double evaluate(float x) {
        double out = 0.0;
        for (int i = 0; i < coefficients.length; i++) {
            out += coefficients[i] * Math.pow(x, degree-i);
        }
        return out;
    }
}