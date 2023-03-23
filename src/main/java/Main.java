import methods.LeftRectangleMethod;
import methods.SimpsonMethod;

public class Main {
    public static void main(String[] args) {
        LeftRectangleMethod simpsonMethod = new LeftRectangleMethod(1,0,2,10);
        double sum = simpsonMethod.getIntegral(10);
        double res = simpsonMethod.getInfelicity(1);
        System.out.println(sum);
        System.out.println(res);
    }
}