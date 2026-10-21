package org.example;

public class Park {
    public class Attraction{
        String name;
        String workingHours;
        double price;
        public Attraction(String name,String workingHours,double price){
            this.name = name;
            this.workingHours = workingHours;
            this.price = price;
        }
        public void information(){
            System.out.println("Аттракцион: " + name + ", время: " + workingHours + ", цена: " + price);
        }
    }
}
