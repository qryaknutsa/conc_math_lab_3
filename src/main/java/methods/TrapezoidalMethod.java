package methods;

public class TrapezoidalMethod extends Method {

    public TrapezoidalMethod(int chosenFunction, double a, double b, int n) {
        super(chosenFunction, a, b, n);
    }

    @Override
    public double getIntegral(int n) {
        double a = super.getA();
        double b = super.getB();
        double h = (b - a) / n;
        double x;
        double res = 0;
        for (float i = 1; i < n; i++) {
            x = i * h + a;
            res += f(x);
        }
        res = (h / 2) * (f(a) + f(b) + 2 * res);
        return res;
    }

}
