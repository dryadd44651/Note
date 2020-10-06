//https://www.geeksforgeeks.org/virtual-destructor/
#include<iostream> 
  
using namespace std; 
//concept derived has two part(base and derived)
//base *b = d; can get the base part from derived
//delete b, d can still live
//delete d, both will deleted

class base { 
  public: 
    int i =0;
    base()      
    { cout<<"Constructing base \n"; } 
    ~base() 
    { cout<<"Destructing base \n"; }      
    void f(){
        cout<<"base \n";
    }
}; 
  
class derived: public base { 
  public: 
    derived()      
    { cout<<"Constructing derived \n"; } 
    ~derived() 
    { cout<<"Destructing derived \n"; } 
    void f(){
        cout<<"derived\n";
    }
    void f1(){
        cout<<"derived"<<i<< "\n";
    }
}; 
  
int main(void) 
{ 
    derived *d = new derived();   
    base *b = d; //b will be assign the base class from d
    // d->f();
    // b->f();
    //delete d; //both destructor will be called base and derived
    delete b;//Destructing base -> which will cause problem(only destruct base)
    //base: virtual ~base() -> delete b: call ~base and ~derived 
    //if we have other virtual function in base(need virtual ~base())
    //b->i = 2;
    d->f();
    //d->f1(); //error b has been delete (i is also deleted)
    
    
    //base *bb = new base();
    //derived *dd = bb; //error

    return 0; 
} 
