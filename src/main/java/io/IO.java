package io;

import methods.*;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.Math.abs;
import static java.lang.Math.pow;

public class IO {
    int chosenFunction;
    int chosenMethod;

    //equation
    double a;
    double b;
    double e;


    void readFromConsole() {
        Scanner in = new Scanner(System.in);
        System.out.println("-----------------------\n1) -x³ - x² - 2x + 1");
        System.out.println("2) x⁴ - 4x² + sin(4x²)");
        System.out.println("3) 2e³ˣ - 2e²ˣ² + 4x");
        System.out.println("4) 120x⁷ - 4x⁻² + 16");
        System.out.print("Выберите уравнение по номеру: ");
        try {
            chosenFunction = in.nextInt();
            if (chosenFunction > 5 || chosenFunction < 1) {
                System.out.println("\nТакой опции нет.");
                System.exit(-1);
            }
            System.out.println("-----------------------\n1) Метод левых прямоугольников");
            System.out.println("2) Метод правых прямоугольников");
            System.out.println("3) Метод средних прямоугольников");
            System.out.println("4) Метод трапеций");
            System.out.println("5) Метод Симпсона");
            System.out.print("Выберите метод решения по номеру: ");
            in = new Scanner(System.in);
            try {
                chosenMethod = in.nextInt();
                if (chosenMethod > 5 || chosenMethod < 1) {
                    System.out.println("\nТакой опции нет.");
                    System.exit(-1);
                }
                System.out.println("Введите исходные данные (а - нижний предел, b - верхний предел, n - число разбиений)");
                in = new Scanner(System.in);
                System.out.print("а = ");
                a = Double.parseDouble(in.nextLine().replace(',', '.'));

                in = new Scanner(System.in);
                System.out.print("b = ");
                b = Double.parseDouble(in.nextLine().replace(',', '.'));

                in = new Scanner(System.in);
                System.out.print("e = ");
                e = Double.parseDouble(in.nextLine().replace(',', '.'));
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("\nТакой опции нет. Ошибка 4.");
                System.exit(-1);
            }
        } catch (InputMismatchException | NumberFormatException e) {
            System.out.println("\nТакой опции нет. Ошибка 3.");
            System.exit(-1);
        }
    }


    public double getInfelicity(Method method, int n) {
        int k;
        if (method.getClass() == SimpsonMethod.class) k = 4;
        else k = 2;
        return (method.getIntegral(2 * n) - method.getIntegral(n)) / (pow(2, 2) - 1);
    }

    public void solve() {
        Method method;
        readFromConsole();
        switch (chosenMethod) {
            case 1 -> method = new LeftRectangleMethod(chosenFunction, a, b, e);
            case 2 -> method = new RightRectangleMethod(chosenFunction, a, b, e);
            case 3 -> method = new MiddleRectangleMethod(chosenFunction, a, b, e);
            case 4 -> method = new TrapezoidalMethod(chosenFunction, a, b, e);
            default -> method = new SimpsonMethod(chosenFunction, a, b, e);
        }
        int n = 4;
        double delta = getInfelicity(method, n);
        while (abs(delta) >= e) {
            n++;
            delta = getInfelicity(method, n);
        }
        double res = method.getIntegral(n);
        System.out.println("S = " + res);
        System.out.println("p = " + delta);
        System.out.println("Количество разбиения интервала - " + n);
    }

}
