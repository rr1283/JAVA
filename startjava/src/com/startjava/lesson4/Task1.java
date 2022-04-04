package com.startjava.lesson4;

//   Найти максимальный по модулю элемент в массиве с уникальными по модулю значениями
//   Заполнить массив случайными положительными и отрицательными числами таким образом,
//   чтобы все числа по модулю были разными. Это значит, что в массиве не может быть ни
//   только двух равных чисел, но не может быть двух равных по модулю. В полученном массиве
//   найти наибольшее по модулю число.
//    Абсолютное значение каждого нового числа перед помещением в массив надо сравнить с
//    абсолютными значениями всех чисел, которые уже были добавлены в массив.
//    Если хотя бы в одном сравнении числа совпадут, то новое число не следует добавлять в массив.
//    Если же совпадений не было, то число добавляется массив по текущему индексу,
//    после чего индекс увеличивается на 1


import java.util.Scanner;
import static java.lang.Math.*;
//***
    public class Task1 {


        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Введите длину массива: ");
            int maxLength = scanner.nextInt();
            int[] numbers = new int[maxLength];

            System.out.println("Заполните массив целыми числами через пробел: ");

           // numbers[0] = scanner.nextInt();
            int tmp = 0;
            int nextScanner;

            for(int i=0; i<maxLength; i++) {

                nextScanner = scanner.nextInt();

                for(int j : numbers) if (abs(numbers[j]) == abs(nextScanner)) {
                    tmp = tmp+1;
                }

                if(tmp == 0){
                    numbers[i] = nextScanner;

                }else i=i-1;
                tmp = 0;
            }

            for (int number : numbers) {
                System.out.print(number + " ");
            }

            System.out.println();


            int v_max = numbers[0];
            int v_num = 0;

            for (int j = 0; j < maxLength - 1; j++) {
                if (abs(v_max) < abs(numbers[j + 1])) v_max = numbers[j + 1];
                if (v_max != numbers[0]) v_num = j + 1;
            }
            System.out.println("Максимальное число = " + v_max);
            System.out.println("Номер элемента в массиве = " + v_num);
        }
    }