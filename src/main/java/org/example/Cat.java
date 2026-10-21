package org.example;

public class Cat extends Animal{
  private boolean isCatFull = false;

    public Cat(String name){
        super(name);
    }

    @Override
    public void run(int value) {
        if(value <=200){
            System.out.println(getName() + " пробежал " + value + "м");
        }
        else {
            System.out.println(getName() + " не может пробежать больше 200м");
        }
    }
    public boolean isCatFull(){
        return isCatFull;
    }

    @Override
    public void swim(int value) {
        System.out.println(getName() + " плавать не умеет :( ");
    }
    public void eat(Bowl bowl){
     if(isCatFull) {
    System.out.println(getName() + " уже сыт и не хочет есть.");
} else if(bowl.getFood() >= 15){
         bowl.decreaseFood(15);
         isCatFull = true;
         System.out.println(getName() + " поел и теперь сыт!");
     }
     else {
         System.out.println(getName() + " не стал есть, в миске слишком мало еды");
     }
    }
}
