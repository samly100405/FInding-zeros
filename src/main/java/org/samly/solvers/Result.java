package org.samly.solvers;

public class Result {
    private final float root;
    private final int iterations;
    private final boolean success;

    public Result(float root, int iterations, boolean success) {
        this.root = root;
        this.iterations = iterations;
        this.success = success;
    }

    public float getRoot() {
        return root;
    }

    public int getIterations() {
        return iterations;
    }

    public boolean isSuccess() {
        return success;
    }

    public String toString() {
        return root + " " + iterations + " " + success;
    }
}
