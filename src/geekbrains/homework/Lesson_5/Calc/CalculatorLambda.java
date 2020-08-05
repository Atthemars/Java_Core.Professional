package geekbrains.homework.Lesson_5.Calc;

import java.util.Scanner;

public class CalculatorLambda {
    interface Operational {
        double calculate(double x, double y);
    }
    public static void main(String[] args) {
        Operational operAdd = (double x, double y) -> x + y;
        Operational operSub = (double x, double y) -> x - y;
        Operational operMult = (double x, double y) -> x * y;
        Operational operDiv = (double x, double y) -> x / y;
        System.out.println("This is cut version of console lmbd calculator, if you want to use Addition press 1;" +
                "If you would like to Subtract numbers press 2" +
                "If you would like to  Multiply numbers press 3" +
                "If you would like to make use of Division press 4");
        Scanner urChoice = new Scanner(System.in);
        int Oper = urChoice.nextInt();
        switch (Oper){
            case 1 -> {
                System.out.println(" you've choose to find summary of two fraction numbers, please insert first number");
                double x = urChoice.nextDouble();
                System.out.println("Please insert second one");
                double y = urChoice.nextDouble();
                System.out.println(operAdd.calculate(x, y));
            }
            case 2 -> {
                System.out.println(" you've choose to find subtraction between two fraction numbers, please insert first number");
                double x = urChoice.nextDouble();
                System.out.println("please insert second one");
                double y = urChoice.nextDouble();
                System.out.println(operDiv.calculate(x, y));
            }
            case 3 -> {
                System.out.println(" you've choose to multiply two fraction numbers, please insert first number");
                double x = urChoice.nextDouble();
                System.out.println("please insert second one");
                double y = urChoice.nextDouble();
                System.out.println(operMult.calculate(x, y));
            }
            case 4 -> {
                System.out.println(" you've choose to split two fraction numbers, please insert first number");
                double x = urChoice.nextDouble();
                System.out.println("please insert second one");
                double y = urChoice.nextDouble();
                System.out.println(operDiv.calculate(x, y));
            }
            default -> throw new IllegalArgumentException("You've press wrong operation number, please choose between 1-4");
        };
    }
}

