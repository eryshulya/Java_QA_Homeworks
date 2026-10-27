package org.example;
public class Main {
  public static void main(String[] args) {
        System.out.println(arithmeticOperations(5,7,'/'));
    }

    public static int findFactorial(int x){
        if (x < 0) {
            throw new IllegalArgumentException("Факториал отрицательного числа не определён");
        }
      if(x == 0){
          return 1;
      }
        int result = 1;
        for (int i = 1; i <= x; i++) {
            result =result * i;
        }
        return result;
    }
    public static double triangleArea(double base, double height) {
      if(base <=0 || height <= 0){
          throw new IllegalArgumentException("Основание и высота должны быть больше нуля");
      }
        return base * height / 2;
    }
    public static double arithmeticOperations(int a, int b, char c){
      if(c == '*'){
          return a*b;
      }
      if(c == '+'){
        return a+b;
      }
      if(c == '-'){
          return a - b;
      }
      if(c == '/'){
          if (b == 0){
              throw new ArithmeticException("Деление на 0 невозможно");
          }
          return (double)a / b;
      }
        throw new IllegalArgumentException("Неизвестная операция");
    }
       public static String comparisonResult(int a, int b){
      if(a > b){
          return "Число " + a + " больше числа " + b + ".";
      }
      if(a == b){
          return "Число " + a + " равно числу " + b + ".";
      }
      if( a < b){
          return "Число " + a + " меньше числа " + b + ".";
      }
      return "";
       }
    }
