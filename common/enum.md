# java
```
enum Type
{
  AMPHIBIAN,
  MAMMAL,
  REPTILE,
  BIRD
}

enum Animal 
{
  ELEPHANT(Type.MAMMAL),
  GIRAFFE(Type.MAMMAL),
  TURTLE(Type.REPTILE),
  SNAKE(Type.REPTILE),
  FROG(Type.AMPHIBIAN);

  private final Type type; 
  private Animal(final Type type) { this.type = type; }
  public boolean isMammal() { return this.type == Type.MAMMAL; }
  public boolean isAmphibian() { return this.type == Type.AMPHIBIAN; }
  public boolean isReptile() { return this.type == Type.REPTILE; }
  // etc...
}
public class Main {
    public static void main(String[] args) {
        Animal a = Animal.ELEPHANT;
        System.out.println(a.isMammal());
    }
}
//true
```

# c++
```
class  Type
{
  public:
    enum{AMPHIBIAN,MAMMAL,REPTILE,BIRD};

};
class Animal 
{
    public:
    int type;
    Animal(int n) {
        //type = 1;
        switch (n) {
            case ELEPHANT:
                type = Type::MAMMAL;
                break;
            case GIRAFFE:
                type = Type::MAMMAL;
                break;
            case TURTLE:
                type = Type::REPTILE;
                break;
            case SNAKE:
                type = Type::REPTILE;
                break;
            case FROG:
                type = Type::AMPHIBIAN;
                break;
            default:
                type = Type::AMPHIBIAN;
                break;
        }
    }
    enum{ELEPHANT,GIRAFFE,TURTLE,SNAKE,FROG};
    bool isMammal() { return type == Type::MAMMAL; }
    bool isAmphibian() { return type == Type::AMPHIBIAN; }
    bool isReptile() { return type == Type::REPTILE; }
};


int main() {
    std::cout << Type::MAMMAL<<endl;
    Animal a(Animal::GIRAFFE);
    cout<<a.isMammal()<<endl;
    cout<<a.isAmphibian()<<endl;
    enum{ZERO,ONe,TWO,THREE};
    cout<<THREE<<endl;
}
//1
//1
//0
//3
```

# Python

```
class Animal:
    DOG = 1
    CAT = 2


print( Animal.DOG)
#1
```
