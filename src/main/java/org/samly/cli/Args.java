package org.samly.cli;

import com.beust.jcommander.IStringConverter;
import com.beust.jcommander.Parameter;

import java.io.File;
import java.util.List;

public class Args {
    @Parameter(description = "Input File", converter = FileConverter.class)
    private File file;

    @Parameter(names = {"--bis"}, description = "Use Bisection Method. Requires 2 range.")
    private Boolean isBisection = false;

    @Parameter(names = {"--newt"}, description = "Use Newton's Method. Requires only 1 start.")
    private Boolean isNewton = false;

    @Parameter(names = {"--sec"}, description = "Use Secant Method. Requires 2 range.")
    private Boolean isSecant = false;

    @Parameter(names = {"--hybrid"}, description = "Use use hybrid method. Requires 2 range.")
    private Boolean isHybrid = false;

    @Parameter(names = {"--range", "-r"}, description = "Define the starting range.", variableArity = true)
    List<String> range;

    private static class FileConverter implements IStringConverter<File> {
        @Override
        public File convert(String value) {
            return new File(value);
        }
    }

    public File getFile() {
        return file;
    }

    public Boolean getBisection() {
        return isBisection;
    }

    public void setIsBisection(boolean b) {
        isBisection = b;
    }

    public Boolean getNewton() {
        return isNewton;
    }

    public Boolean getSecant() {
        return isSecant;
    }

    public Boolean getHybrid() {
        return isHybrid;
    }

    public List<String> getRange() {
        return range;
    }

    public String getDescription() {
        String out = "";

        if (isBisection) out += "Bisection method";
        else if (isNewton) out += "Newtons method";
        else if (isSecant) out += "Secant method";
        else if (isHybrid) out += "Hybrid method";

        out += "\nRange: " + range.toString();

        return out;
    }
}
