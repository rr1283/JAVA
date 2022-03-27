package com.startjava.lesson3;

import java.util.Scanner;

public class CalculatorTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calc = new Calculator();

        System.out.println("Start!");

        String answer = "yes";
        while(answer.equals("yes")) {

        System.out.print("Enter one ");
        int firstNumber = scanner.nextInt();
        calc.setFirstNumber(firstNumber);


        System.out.print("Enter char ");
        String text = scanner.next();
        char mathOperation = text.charAt(0);
        calc.setMathOperation(mathOperation);

      //  char mathOperation scanner.next().charAt(0);

        System.out.print("Enter two ");
        int secondNumber = scanner.nextInt(); 
        calc.setSecondNumber(secondNumber);

        calc.calculate();


        do {
        	System.out.print("Begin? yes/no ");
					answer = scanner.next();
        } while(!answer.equals("yes") && !answer.equals("no"));


			}

      System.out.println("End!");

    }	

}