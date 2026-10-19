package org.example;

import java.util.Arrays;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
       printThreeWords();//1
       checkSumSign();//2
       printColor();//3
       compareNumbers();//4
       isTrueOrFalse(15,7); //5
        isValuePositiveOrNegative(89);//6
        isValueNegative(-7);//7
      howManyWeCanPrintStrings(5,"Hello"); //8
      System.out.println(whatYearIsIt(2028));//9
       changeArray();//10
       fillingInTheArray();//11
        multiplyingTheValues();//11
    }
    //1
    public static void printThreeWords(){
        System.out.println("Orange"+ "\n" +"Banana" + "\n" + "Apple");
    }
    //2
    public static void checkSumSign(){
        int a = 5;
        int b = 2;
        int sum = a + b;
        if (sum >= 0){
            System.out.println("Сумма положительная");
        }
        else{
            System.out.println("Сумма отрицательная");
        }
    }
    //3
    public static void printColor(){
        int value = 9;
        if(value <= 0) {
            System.out.println("Красный");
        }
        else if ( value > 0 && value <=100 ) {
            System.out.println("Желтый");
        }
        else {
            System.out.println("Зеленый");
        }
    }
    //4
    public static void compareNumbers(){
        int a = 67;
        int b = 76;
           if(a >= b) {
               System.out.println("a >= b");
           }
           else {
               System.out.println("a < b");
           }
    }
    //5
    public static boolean isTrueOrFalse(int a, int b){
        int sum = a + b;
        return sum >= 10 && sum <= 20 ? true : false;
    }
    //6
 public static void isValuePositiveOrNegative(int a){
       if(a >= 0){
           System.out.println("Число положительное");
       }
       else {
           System.out.println("Число отрицательное");
       }
 }
 //7
    public static boolean isValueNegative(int a){
        return a < 0 ? true : false;
    }
    //8
    public static void howManyWeCanPrintStrings(int a, String str){
       int i = 0;
     while (i < a){
         System.out.println(str);
         i++;
     }
    }
    //9
    public static boolean whatYearIsIt(int year){
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
    //10
    public static void changeArray(){
        int[] arr = {0,0,1,0,1,1,0};
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 0){
                arr[i] = 1;
            }
            else {
                arr[i] = 0;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
    //11
    public static void fillingInTheArray(){
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        System.out.println(Arrays.toString(arr));
    }
    //12
    public static void multiplyingTheValues(){
        int[] arr = {1,5,3,2,11,4,5,2,4,8,9,1};
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < 6){
                arr[i] = arr[i] * 2;
        }
        }
        System.out.println(Arrays.toString(arr));
    }
}