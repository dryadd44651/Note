# c++
```
#include <stdio.h> 
// A normal function with an int parameter 
// and void return type 
void fun(int a) 
{ 
	printf("Value of a is %d\n", a); 
} 

int main() 
{ 
	// void (*fun_ptr)(int); // & removed 
	// fun_ptr = &fun;
	// (*fun_ptr)(10); // * removed 
    void (*fun_ptr)(int); // & removed 
	fun_ptr = fun;
	fun_ptr(10); // * removed 
    
	return 0; 
}
```
```
// A simple C program to demonstrate callback 
#include<stdio.h> 

void A() 
{ 
	printf("I am function A\n"); 
} 

// callback function 
void B(void (*ptr)()) 
{ 
	(*ptr) (); // callback to A 
} 

int main() 
{ 
	void (*ptr)() = &A; 
	
	// calling function B and passing 
	// address of the function A as argument 
	B(ptr); 

return 0; 
} 

```
# java
```
class Pig{
    public void callback(){
        System.out.println("what you want to say");
    }
    public void animalSound() {
        System.out.println("wee wee");
    }
    public void sleep() {
        callback();
        System.out.println("Zzz!!");
    }
    public void cry() {
        System.out.println("cry");
    }
};

class MyMainClass {
    public static void main(String[] args) {
        Pig a;
        a = new Pig(){
            public void callback() {
                System.out.println("good night");
            }
        };
        a.sleep();//pig sleep
        
  }
}
```
```
class Example {
    // Method that takes a "method" as argument
    static void exampleMethod(Runnable toRun) {
        
        toRun.run();
        System.out.println("ZZzz");
    }

    // Method to pass
    static void sayHello() {
        System.out.println("Hello");
    }

    public static void main(String[] args) {
        exampleMethod(Example::sayHello);  // prints "Hello"
    }
}
```
# python
```
def operation(callback=None, arr=None):
    if callback==None:
        return sum(a)
    res = arr[0]
    for i in arr[1:]:
        res = callback(res,i)
    return res
a = [1,2,3,4]
print(operation(lambda x, y: x*y, a))
```
