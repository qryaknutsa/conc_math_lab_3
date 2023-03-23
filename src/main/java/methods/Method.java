package methods;

import static java.lang.Math.*;

public abstract class Method implements IIntegrable {
    private final int chosenFunction;

    public int getChosenFunction() {
        return chosenFunction;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    private final double a;
    private final double b;
    private final double e;


    public Method(int chosenFunction, double a, double b, double e) {
        this.chosenFunction = chosenFunction;
        this.a = a;
        this.b = b;
        this.e = e;
    }

    double f(double x) {
        return switch (chosenFunction) {
            case 1 -> -pow(x, 3) - pow(x, 2) - 2 * x + 1;
            case 2 -> 2;
            case 3 -> 3;
            case 4 -> 4;
            default -> 0;
        };
    }



    @Override
    public double getIntegral(int n) {
        return 0;
    }


}
