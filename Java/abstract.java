abstract class Animal {//can have base case
    public void sleep() {
        System.out.println("ZZZzz");
    }
    abstract public void animalSound(); 
    
}
//class Pig extends Animal,Mammal => is not allowed
//Because Animal,Mammal may have same function(deadly diamond problem)
//slove by interface multi implement/ inner class
class Pig extends Animal {
  public void animalSound() {
    System.out.println("The pig says: wee wee");
  }
  
}

class MyMainClass {
  public static void main(String[] args) {
    Pig myPig = new Pig();
    myPig.animalSound();
    myPig.sleep();
  }
}
