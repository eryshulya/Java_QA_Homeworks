package org.example;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneDirectory {
   private Map<String, List<String>> phoneBook = new HashMap<>();
  public void add(String name, String phone){
      if (phoneBook.containsKey(name)){ //если имя уже есть в справочнике
          if(!phoneBook.get(name).contains(phone))//и к этому имени не привязан тот же номер{
             phoneBook.get(name).add(phone); // добавляем ключ-имя и значение-номер
          } else { //если имени еще нет
          List<String> phones = new ArrayList<>(); //создаем список с номерами
          phones.add(phone); // добавляем номер в список с номерами
          phoneBook.put(name,phones); // связываем пару ключ-значение
      }
  }
  public List<String>get(String name){
     return phoneBook.containsKey(name) ? phoneBook.get(name) : null;
  }

    public static void main(String[] args) {
        PhoneDirectory directory = new PhoneDirectory();
        directory.add("Иванов", "111");
        directory.add("Петров", "222");
        directory.add("Иванов", "333");
        directory.add("Сидоров", "444");
        directory.add("Иванов", "111");
        directory.add("Петров", "555");
        System.out.println(directory.get("Иванов")); //дубликатов нет, печатаются два номера 111 и 333
    }
}
