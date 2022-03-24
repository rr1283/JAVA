package com.startjava.wolf;

public class Calculator {

    private int firstNumber;
    private int secondNumber;
    private char mathOperation;

    public void setFirstNumber(int firstNumber) {
        this.firstNumber = firstNumber;
    }

    public void setSecondNumber(int secondNumber) {
        this.secondNumber = secondNumber;
    } 

    public void setMathOperation(char mathOperation) {
        this.mathOperation = mathOperation;
    }

    public void calculate() {
        switch(mathOperation) {
        case '+':
            System.out.println("Result " + (firstNumber + secondNumber)); 
            break;
        case '-':
            System.out.println("Result " + (firstNumber - secondNumber)); 
            break;
        case '*':
            System.out.println("Result " + (firstNumber * secondNumber)); 
            break;
        case '/':
            System.out.println("Result " + (firstNumber / secondNumber)); 
            break;
        case '^':
            pow();
            break;
        default: System.out.println("Error"); 

        }
    }

    private void pow() {
        int result = 1;
        for(int i=0; i<secondNumber;i++) {
            result = result * firstNumber;
        }
        System.out.println("Result " + result); 
    }

}

