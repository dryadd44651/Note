abstract class Animal {//can have base case
    public void sleep() {
        System.out.println("ZZZzz");
    }
    abstract public void animalSound(); 
    int num = 0;
}

class Pig extends Animal {
  public void animalSound() {
    System.out.println("The pig says: wee wee");
  }
    public void sleep() {
        System.out.println("ZZZzz!!!");
    }
    public void run() {
        System.out.println("running");
    }
  
}

class MyMainClass {
    public static void main(String[] args) {
        Pig myPig = new Pig();
        myPig.animalSound();
        myPig.sleep();
        //take the animal part form pig
        Animal a = myPig;//big to small
        myPig.num = 10;
        System.out.println(myPig.num+" "+a.num);
        a.animalSound();//overwrite
        a.sleep();//overwrite
        //a.run();//animal doesn't have run
    }
}
