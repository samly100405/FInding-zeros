package org.samly;

import com.beust.jcommander.JCommander;
import org.samly.cli.Args;
import org.samly.solvers.Polynomial;
import org.samly.solvers.Result;
import org.samly.solvers.Solver;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    private static Polynomial generatePolynomial(File file) throws FileNotFoundException {
        Scanner s = new Scanner(file);

        int degree = s.nextInt();

        float[] coefficients = new float[degree + 1];
        for (int i = 0; i < coefficients.length; i++) {
            coefficients[i] = s.nextFloat();
        }

        return new Polynomial(degree, coefficients);
    }

    private static Result solveWithArgs(Args args) throws FileNotFoundException {
        Polynomial f = generatePolynomial(args.getFile());
        if (args.getBisection()) {
            return Solver.BisectionMethod(f, args.getRange(), args.getMaxIter());
        }

        return null;
    }
    public static void main(String[] args) throws FileNotFoundException {
        // generate polynomial from file

        Args a = new Args();
        JCommander.newBuilder()
                .addObject(a)
                .build()
                .parse(args);

        System.out.println(a.getDescription());

        System.out.println(solveWithArgs(a));
    }
}
