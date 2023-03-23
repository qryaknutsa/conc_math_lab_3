package methods;

public class MiddleRectangleMethod extends Method {

    public MiddleRectangleMethod(int chosenFunction, double a, double b, double e) {
        super(chosenFunction,a,b,e);
    }


    @Override
    public double getIntegral(int n) {
        double a = super.getA();
        double b = super.getB();
        double h = (b - a) / n;
        double res = 0;
        double x;
        for (float i = 0; i < n; i++) {
            x = (2 * i + 1) / 2 * h + a;
            res += f(x);
        }
        res *= h;
        return res;
    }


}
