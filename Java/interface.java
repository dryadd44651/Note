interface Animal {//no base case
    
    public void animalSound(); // interface method (does not have a body)
    default public void sleep() {
    System.out.println("Zzz");
  }
    default public void cry() {
    System.out.println("QQ");
  }
}
interface Mammal {//no base case
    
    public void animalSound(); 
    default public void sleep() {
    System.out.println("Zzz!!!");
  }
  //   default public void cry() {this fucntion will conflict with Animal.cry
  //   System.out.println("QQ");
  // }
}

class Pig implements Animal ,Mammal{
  public void animalSound() {
    System.out.println("The pig says: wee wee");
  }
  public void sleep() {
    System.out.println("ZZZzz");
  }
}

class MyMainClass {
  public static void main(String[] args) {
    Animal myPig = new Pig();
    myPig.animalSound();
    myPig.sleep();
  }
}
