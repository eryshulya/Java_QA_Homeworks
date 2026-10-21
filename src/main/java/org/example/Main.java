package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Bowl bowl = new Bowl(40);
        Cat[] cats = {new Cat("Барсик"), new Cat("Васёк"), new Cat("Рыжик")};
        for (Cat cat : cats) {
            cat.eat(bowl);
        }
        System.out.println("-----Итог-----");

        for (Cat cat : cats) {
            System.out.println(cat.getName() + " сыт? " + cat.isCatFull());
        }
    }
}