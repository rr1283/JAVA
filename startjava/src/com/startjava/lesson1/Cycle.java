package com.startjava.lesson1;

public class Cycle {

  public static void main(String[] args) {
	
    int i;
    int j=6;
    int k=10;
    int res=0;

    // Выведите на консоль с помощью цикла for все числа от [0, 20]	
   	for (i=0;i<=20;i++) {
   		System.out.println(i);
   	}

   	// Выведите на консоль с помощью цикла while все числа от [6, -6] (с шагом итерации 2)
    while(j>-7) {
   		System.out.println(j);
   		j = j-2;
    }

   	// Подсчитайте с помощью цикла do-while сумму нечетных чисел от [10, 20]. Выведите ее на консоль
    do{
    	  for(k=10;k<21;k++) {
    	     if(k%2 == 0) {
    	 	   res=res+k;	
    	     }
        }
      System.out.println(res);
    } while(k<21);

 	}
}



