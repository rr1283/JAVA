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
        String result = "";
        switch(mathOperation)
          {
            case '+':
                result = String.valueOf(Math.addExact(firstNumber,secondNumber));
                break;
            case '-':
//                result = String.valueOf(
//                break;
//            case '*':
//                System.out.println("Result " + (firstNumber * secondNumber));
//                break;
//            case '/':
//                System.out.println("Result " + (firstNumber / secondNumber));
//                break;
//            case '^':
//                pow();
//                break;
            default: System.out.println("Error");

        }
        return result;
    }

    private void pow() {
        int result = 1;
        for(int i=0; i<secondNumber;i++) {
            result = result * firstNumber;
        }
        System.out.println("Result " + result);
    }


}