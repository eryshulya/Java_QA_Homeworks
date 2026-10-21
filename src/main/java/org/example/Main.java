package org.example;
public class Main {
    public static void main(String[] args) {
        Product[] productsArray = new Product[5];
        productsArray[0] = new Product("Samsung S25 Ultra", "01.02.2025", "Samsung Corp.", "Korea", 5599.00, true);
        productsArray[1] = new Product("iPhone 15 Pro", "15.09.2024", "Apple Inc.", "USA", 1199.99, false);
        productsArray[2] = new Product("Xiaomi 14", "10.11.2024", "Xiaomi", "China", 899.50, true);
        productsArray[3] = new Product("Google Pixel 8", "05.10.2024", "Google LLC", "USA", 749.00, false);
        productsArray[4] = new Product("OnePlus 12", "20.01.2025", "BBK Electronics", "China", 699.99, true);
        for (int i = 0; i < productsArray.length; i++) {
            productsArray[i].printInformationAboutProduct();
            System.out.println("---------------------------------"); // Разделитель для красоты
        }
        Park park = new Park();
        Park.Attraction attr = park.new Attraction("Колесо обозрения","05:00",190.00);
    }
}