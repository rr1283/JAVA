package com.startjava.lesson4;

public class CalculatorArray {

    private int firstNumber;
    private int secondNumber;
    private char mathOperation;

    String string;

    public void text(String string) {
        this.string = string;
        String[] words = this.string.split(" ");
        firstNumber = Integer.parseInt(words[0]);
        mathOperation = words[1].charAt(0);
        secondNumber = Integer.parseInt(words[2]);
    }

    String calculate() {
        String result = null;
        switch(mathOperation)
          {
            case '+':
                result = String.valueOf(Math.addExact(firstNumber,secondNumber));
                break;
            case '-':
                result = String.valueOf(Math.subtractExact(firstNumber,secondNumber));
                break;
            case '*':
                result = String.valueOf(Math.multiplyExact(firstNumber,secondNumber));
                break;
            case '/':
                result = String.valueOf(firstNumber / secondNumber);
                break;
            case '^':
                result = String.valueOf(Math.pow(firstNumber,secondNumber));
                break;
            default: System.out.println("Error");

        }
        return result;
    }

}