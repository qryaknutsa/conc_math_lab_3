package methods;

public class SimpsonMethod extends Method {

    public SimpsonMethod(int chosenFunction, double a, double b, double e) {
        super(chosenFunction,a,b,e);
    }

    @Override
    public double getIntegral(int n) {
        double a = super.getA();
        double b = super.getB();
        double h = (b - a) / n;
        double x;
        double sum1 = 0;
        double sum2 = 0;
        for (float i = 1; i < n; i++) {
            x = i * h + a;
            if (i % 2 == 0) sum2 += f(x);
            else sum1 += f(x);
        }
        return (h / 3) * (f(a) + 4 * sum1 + 2 * sum2 + f(b));
    }

}
