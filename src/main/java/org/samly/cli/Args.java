package org.samly.cli;

import com.beust.jcommander.IStringConverter;
import com.beust.jcommander.Parameter;

import java.io.File;
import java.util.List;

public class Args {
    @Parameter(description = "Input File", converter = FileConverter.class)
    private File file;

    @Parameter(names = {"--newt"}, description = "Use Newton's Method. Requires only 1 start.")
    private Boolean isNewton = false;

    @Parameter(names = {"--sec"}, description = "Use Secant Method. Requires 2 range.")
    private Boolean isSecant = false;

    @Parameter(names = {"--hybrid"}, description = "Use use hybrid method. Requires 2 range.")
    private Boolean isHybrid = false;

    @Parameter(names = {"--range", "-r"}, description = "Define the starting range.", variableArity = true,
            listConverter = FloatConverter.class)
    List<Float> range;

    @Parameter(names = {"--maxIter"}, description = "Maximum iterations")
    private Integer maxIter = 10000;

    private static class FileConverter implements IStringConverter<File> {
        @Override
        public File convert(String value) {
            return new File(value);
        }
    }

    private static class FloatConverter implements IStringConverter<Float> {
        @Override
        public Float convert(String value){
            return Float.parseFloat(value);
        }
    }

    public File getFile() {
        return file;
    }

    public Boolean getBisection() {
        return true;
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

    public List<Float> getRange() {
        return range;
    }

    public Integer getMaxIter() {
        return maxIter;
    }

    public String getDescription() {
        String out = "";

        if (isNewton) out += "Newtons method";
        else if (isSecant) out += "Secant method";
        else if (isHybrid) out += "Hybrid method";
        else               out += "Bisection Method";

        out += "\nRange: " + range.toString();

        return out;
    }
}
