package org.example;

public class Dog extends Animal{
 public Dog(String name){
     super(name);
 }
    @Override
    public void run(int value) {
        if(value <= 500){
            System.out.println(getName() + " пробежал " + value + "м");
        }
        else {
            System.out.println(getName() + " не может пробежать больше 500м");
        }
    }

    @Override
    public void swim(int value) {
      if(value <= 10){
          System.out.println(getName() + " проплыл " + value + "м");
      }
      else {
          System.out.println(getName() + " не может проплыть больше 10м");
      }
    }
}

