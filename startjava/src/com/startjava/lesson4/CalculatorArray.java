package com.startjava.lesson4;

public class CalculatorArray {


/*
Модифицируйте программу Калькулятор:
используйте следующий формат ввода (пример): Введите математическое выражение: 2 ^ 10 введенное выражение храните в массиве. В этом поможет метод String.split()

для преобразования чисел выражения из String в int используйте метод Integer.parseInt()

замените методами класса Math, какие только сможете найти, ваши реализации вычислений

метод calculate() должен возвращать результат вычисления. Выводите его в CalculatorTest

сделайте метод calculate() статическим. При этом создавать экземпляр Calculator уже не нужно

используйте новый switch expression(1, 2)

делайте проверку, что пользователь использует для вычислений целые положительные числа
при вводе других чисел выводите предупреждение, а также просите его ввести корректные значения

*/

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

