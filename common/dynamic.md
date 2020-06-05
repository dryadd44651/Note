```
// Base class
class Animal {
  public:
    void sleep(){
        cout<<"Zzz"<<endl;
    }
    // Virtual Function 
    virtual void animalSound(){
        cout<<"mew mew"<<endl;
    }
    
};//animal;

// An abstract class 
class Mammal{
    public:
        // Pure Virtual Function 
        virtual void fun() = 0; 
};

class Pig: public Animal,public Mammal {
  public:
    void animalSound(){
        cout<<"cow cow"<<endl;
    }
    void fun(){
        cout<<"this is pure virtual function"<<endl;
    }
};//pig;

int main() {
    Animal *a,*a1;
    Mammal *a2;
    //a = &animal;
    //a1 = &pig;
    a = new Animal;
    a1 = new Pig;
    a->animalSound();
    a1->animalSound();
    a2 = new Pig();
    a2->fun();
    //a2->animalSound(); Mammal has no "animalSound"
    return 0;
}
/*
and other dynamic assign method
class Animal {

}animal;

a = &animal;
*/
```
```
mew mew
Zzz
cow cow
Zzz
this is pure virtual function
```
```
class Animal {//can have base case
    public void sleep() {
        System.out.println("Zzz");
    }
    
    public void animalSound(){
        System.out.println("mew mew");
    }
};
interface Mammal {
  
    default public void sleep(){
        System.out.println("ZZZzzz");
    }
};
class Pig extends Animal implements Mammal {
    
    public void animalSound() {
        System.out.println("wee wee");
    }
    public void sleep() {
        System.out.println("Zzz!!");
    }
    public void cry() {
        System.out.println("cry");
    }
};

class MyMainClass {
    public static void main(String[] args) {
        Animal a,a1;
        a = new Pig();
        a.sleep();//pig sleep
        //a.cry();animal doesn't have cry
        a1 = new Animal();
        a1.sleep();//animal sleep
        Mammal m = new Pig();
        
        
  }
}
```
```
class Animal:
    
    def sleep(self):
        print('Zzz')
    def animalSound(self):
        print("The pig says: mew mew")
        
class Mammal:
    def cry(self):
        print('QQ')
    def sleep(self):
        print('ZZZzz')
class Pig(Animal,Mammal):
    
    # def sleep(self):
    #     print('Zzz!')
    def animalSound(self):
        print("The pig says: wee wee")

pig = None        
pig = Pig()
pig.sleep()#pig>animal>mammal
pig.cry()
pig.animalSound()
pig = Animal()
pig.sleep()#pig>animal>mammal
pig.animalSound()

del pig
```
