java -jar target/cs3010-assignment-3-1.0-SNAPSHOT-runnable.jar data/fun1.pol --hybrid -r 0 1 >> data/fun1_hybrid.sol
java -jar target/cs3010-assignment-3-1.0-SNAPSHOT-runnable.jar data/fun1.pol          -r 0 1 >> data/fun1_bisection.sol
java -jar target/cs3010-assignment-3-1.0-SNAPSHOT-runnable.jar data/fun1.pol --newt   -r 1   >> data/fun1_newton.sol
java -jar target/cs3010-assignment-3-1.0-SNAPSHOT-runnable.jar data/fun1.pol --sec    -r 1 2 >> data/fun1_secant.sol

java -jar target/cs3010-assignment-3-1.0-SNAPSHOT-runnable.jar data/fun2.pol --hybrid -r 0 2 >> data/fun2_hybrid.sol
java -jar target/cs3010-assignment-3-1.0-SNAPSHOT-runnable.jar data/fun2.pol          -r 0 2 >> data/fun2_bisection.sol
java -jar target/cs3010-assignment-3-1.0-SNAPSHOT-runnable.jar data/fun2.pol --newt   -r 2   >> data/fun2_newton.sol
java -jar target/cs3010-assignment-3-1.0-SNAPSHOT-runnable.jar data/fun2.pol --sec    -r 0 2 >> data/fun2_secant.sol

java -jar target/cs3010-assignment-3-1.0-SNAPSHOT-runnable.jar data/fun3.pol --hybrid -r 0 2 >> data/fun3_hybrid.sol
java -jar target/cs3010-assignment-3-1.0-SNAPSHOT-runnable.jar data/fun3.pol          -r 0 2 >> data/fun3_bisection.sol
java -jar target/cs3010-assignment-3-1.0-SNAPSHOT-runnable.jar data/fun3.pol --newt   -r 2   >> data/fun3_newton.sol
java -jar target/cs3010-assignment-3-1.0-SNAPSHOT-runnable.jar data/fun3.pol --sec    -r 0 2 >> data/fun3_secant.sol
