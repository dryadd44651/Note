```
// "static void main" must be defined in a public class.
public class Main {
    public static class objBox {
    private Object object;

    public void set(Object object) { this.object = object; }
    public Object get() { return object; }
    }
    public static class Box<T> {
    // T stands for "Type"
    private T t;

    public void set(T t) { this.t = t; }
    public T get() { return t; }
    }
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Box<Integer> b = new Box<Integer>();
        b.set(1);
        System.out.println(b.get());
        //1
        objBox obj = new objBox();
        obj.set(1);
        System.out.println(obj.get());
        //1
    }
}
```
```
#include <iostream> 
using namespace std; 

// One function works for all data types. This would work 
// even for user defined types if operator '>' is overloaded 
template <typename T> 
T myMax(T x, T y) 
{ 
return (x > y)? x: y; 
} 

int main() 
{ 
cout << myMax<int>(3, 7) << endl; // Call myMax for int 
cout << myMax<double>(3.0, 7.0) << endl; // call myMax for double 
cout << myMax<char>('g', 'e') << endl; // call myMax for char 

return 0; 
}

```
```
#include<iostream> 
using namespace std; 

template<class T, class U = char> 
//template<class T, class U> 
class A { 
public: 
	T x; 
	U y; 
	A() { cout<<"Constructor Called"<<endl; } 
}; 

int main() { 
A<char> a; // This will call A<char, char> 
//A<char,int> a
return 0; 
} 

```
