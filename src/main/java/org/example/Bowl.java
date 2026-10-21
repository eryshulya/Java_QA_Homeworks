package org.example;

public class Bowl {
   private int food;
    public Bowl(int food){
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public void decreaseFood(int amount) {
        if (this.food >= amount) {
            this.food -= amount;
        }
        else {
            System.out.println("В миске недостаточно еды");
        }
    }
    public void addFood(int amount){
        this.food +=amount;
    }
}
