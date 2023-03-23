package methods;

import static java.lang.Math.*;

abstract class Method implements IIntegrable {
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
    private final int n;

    public Method(int chosenFunction, double a, double b, int n) {
        this.chosenFunction = chosenFunction;
        this.a = a;
        this.b = b;
        this.n = n;
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


    public double getInfelicity(int type) {
        int k;
        if (type == 5) k = 4;
        else k = 2;
        IIntegrable method;
        switch (type) {
            case 1 -> method = new LeftRectangleMethod(chosenFunction, a, b, n);
            case 2 -> method = new RightRectangleMethod(chosenFunction, a, b, n);
            case 3 -> method = new MiddleRectangleMethod(chosenFunction, a, b, n);
            case 4 -> method = new TrapezoidalMethod(chosenFunction, a, b, n);
            default -> method = new SimpsonMethod(chosenFunction, a, b, n);
        }
        return (method.getIntegral(2 * n) - method.getIntegral(n)) / (pow(2, k) - 1);
    }


    @Override
    public double getIntegral(int n) {
        return 0;
    }
}
