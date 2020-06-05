```
abstract class Animal {//can have base case
    private String name;
    public Animal(String name){
        this.name = name;
    }
    public void sleep() {
        System.out.println("Zzz");
    }
    public void getName() {
        System.out.println(name);
    }
    abstract public void animalSound(); 
    
}
interface Mammal {
  
    default public void sleep(){
        System.out.println("ZZZzzz");
    }
};
class Pig extends Animal implements Mammal {
    public Pig(String name){
        super(name);
    }
  public void animalSound() {
    System.out.println("The pig says: wee wee");
  }
  
}

class MyMainClass {
    public static void main(String[] args) {
        Pig myPig = new Pig("p");
        myPig.animalSound();
        myPig.sleep();//pid>animal>mammal
        myPig.getName();
        myPig = null;
        
  }
}
```
```
class Animal:
    def __init__(self, name):
        self._name = name
    def getName(self):
        print(self._name)
    def sleep(self):
        print('Zzz')
    def _test():
        print("this is private method")
    def animalSound(self):
        raise NotImplementedError()
        
class Mammal:
    def cry(self):
        print('QQ')
    def sleep(self):
        print('ZZZzz')
class Pig(Animal,Mammal):
    def __init__(self,name):
        Animal.__init__(self,"Mr."+name)
    # def sleep(self):
    #     print('Zzz!')
    def animalSound(self):
        print("The pig says: wee wee")
    
pig = Pig("John")
pig.getName()
pig.sleep()#pig>animal>mammal
pig.cry()
pig.animalSound()
#pig._test()

del pig
```
```
// Base class
class Animal {
  public:
    string name = "";
    Animal(){
        cout<<"animal"<<endl;
    }
    Animal(string name) {
      this->name = name;
    }
    void sleep(){
        cout<<"Zzz"<<endl;
    }
    void animalSound();

};
class Mammal {
  public:
    void sleep(){
        cout<<"ZZZzz"<<endl;
    }
};
// Derived class
class Pig: public Animal,public Mammal {
  public:
    Pig():Animal(){
        cout<<"pig"<<endl;
    }
    Pig(string name):Animal(name){
      cout <<"calling Animal constructor(name)" <<endl;
    }
    void sleep(){//if pig don't override sleep, mammal and animal will conflict
        cout<<"Zzz!"<<endl;
    }
    void animalSound(){
        cout<<"The pig says: wee wee"<<endl;
    }
    
};

int main() {
    Pig pig("PP");
    cout <<pig.name <<endl;
    pig.sleep();
    pig.animalSound();
    Pig pig1;
    
    
    return 0;
}
```
