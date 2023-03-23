package methods;

public class RightRectangleMethod extends Method{
    public RightRectangleMethod(int chosenFunction, double a, double b, int n) {
        super(chosenFunction,a,b,n);
    }


    @Override
    public double getIntegral(int n) {
        double a = super.getA();
        double b = super.getB();
        double h = (b - a) / n;
        double res = 0;
        double x;
        for (float i = 1; i < n+1; i++) {
            x = i * h + a;
            System.out.println(x);
            res += f(x);
        }
        res *= h;
        return res;
    }

}
