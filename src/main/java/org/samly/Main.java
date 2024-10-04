package org.samly;

import com.beust.jcommander.JCommander;
import org.samly.cli.Args;

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
    public static void main(String[] args) throws FileNotFoundException {
        // generate polynomial from file

        Args a = new Args();
        JCommander.newBuilder()
                .addObject(a)
                .build()
                .parse(args);

        System.out.println(a.getDescription());

        Polynomial f = generatePolynomial(a.getFile());

        for (int i = 0; i < 4; i++) {
            System.out.println("f(" + i + ") = " + f.evaluate(i));
        }
    }
}
