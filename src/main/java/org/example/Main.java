package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
     String[][] array = {{"1","2","3","5"},
             {"4","7","5","6"},
             {"7", "8", "9", "10"},
             {"11", "12", "13", "14"},
           };
     try {
         System.out.println(checkArraySize(array));
     } catch (MyArraySizeException e){
         System.out.println(e.getMessage());
     } catch (MyArrayDataException e){
         System.out.println(e.getMessage());
     }
        }
      public static int checkArraySize(String[][]arr) throws MyArraySizeException, MyArrayDataException{
        int sumArray = 0;
        if(arr.length != 4) {
            throw new MyArraySizeException
                    ("Неверный размер массива! Ожидаемый размер массива 4, фактический " + arr.length);
        }
          for (int i = 0; i < arr.length; i++) {
                  if(arr[i].length != 4){
                      throw new MyArraySizeException
                   ("Неверное количество ячеек в массиве! В строке с индексом " + i + "Ожидалось 4, фактически: " + arr[i].length);
              }
          }
          for (int i = 0; i < arr.length; i++) {
              for (int j = 0; j < arr[i].length; j++) {
                try {
                    sumArray+=Integer.parseInt(arr[i][j]);
                }
                catch (NumberFormatException e){
                    throw new MyArrayDataException
                            ("Неверные данные в ячейке [" + i + "][" + j + "]: " + arr[i][j]);
                }
              }
          }
          return sumArray;
      }
      public void arrayIndexOutOfBoundsException() throws ArrayIndexOutOfBoundsException{
        try {
            int[] arr = new int[5];
            arr[6] = 7;
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Выход за пределы массива!");
        }
      }
    }
