package methods;

import java.util.random.RandomGenerator;

public class LeftRectangleMethod extends Method {

    public LeftRectangleMethod(int chosenFunction, double a, double b, int n) {
        super(chosenFunction,a,b,n);
    }

    @Override
    public double getIntegral(int n ) {
        double a = super.getA();
        double b = super.getB();
        double h = (b - a) / n;
        double res = 0;
        double x;
        for (float i = 0; i < n; i++) {
            x = i * h + a;
            res += f(x);
        }
        res *= h;
        return res;
    }

}
