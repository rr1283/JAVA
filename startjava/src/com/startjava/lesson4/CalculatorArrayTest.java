package com.startjava.lesson4;

import com.startjava.lesson4.CalculatorArray;

import java.util.Scanner;

public class CalculatorArrayTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CalculatorArray calc = new CalculatorArray();

        System.out.print("Enter text:");
        String firstNumber = scanner.nextLine();
        calc.text(firstNumber);

        System.out.print(calc.calculate());

    }
}

