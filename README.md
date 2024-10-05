# How to run

## Running manually

1. Make sure you have maven (mvm) installed on your system.
2. Navigate to project root and run `mvn install`.
3. The compiled `.jar` file will be located in the `/target` directory.
4. Use `java -jar target/cs3010-assignment-3-1.0-SNAPSHOT-runnable.jar <flags> <input file>`. *Note: the other .jar file doesn't work*
5. Output is shown in `stdout`.

## Using provided scripts

1. Make sure you have run `mvn install`.
2. Give the scripts execute permissions.
3. `solve.bash` will run all 4 methods on each of the 3 polynomials.
4. the outputs will be stored in `/data`.