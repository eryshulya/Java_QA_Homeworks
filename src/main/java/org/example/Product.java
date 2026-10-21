package org.example;

public class Product {
    String name;
    String productionDate;
    String manufacturer;
    String country;
    double price;
    boolean isBooked;
    public Product(String name,String productionDate,String manufacturer,String country,double price,boolean isBooked){
        this.name = name;
        this.productionDate = productionDate;
        this.manufacturer = manufacturer;
        this.country = country;
        this.price = price;
        this.isBooked = isBooked;
    }
    public void printInformationAboutProduct(){
        System.out.println("Название товара: " + name);
        System.out.println("Дата производства: " + productionDate);
        System.out.println("Производитель: " + manufacturer);
        System.out.println("Страна происхождения: " + country);
        System.out.println("Цена: " + price);
        System.out.println("Состояние бронирования покупателем: " + isBooked);
    }
}
