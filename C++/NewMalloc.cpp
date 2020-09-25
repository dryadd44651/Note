#include "bits/stdc++.h" 
using namespace std; 
  
// Class A 
class A { 
    int a; 
  
public: 
    int* ptr; 
  
    // Constructor of class A 
    A() 
    { 
        cout << "Constructor was Called!"
             << endl; 
    } 
  
    // Destructor of class A 
    ~A() 
    { 
        cout << "Destructor was Called!"
             << endl; 
    } 
}; 
  
// Driver Code 
int main() 
{ 
  
    // Create an object of class A 
    // using new operator 
    A* a = new A; 
    cout << "Object of class A was "
         << "created using new operator!"
         << endl; 
  
    delete (a); 
    cout << "Object of class A was "
         << "deleted using delete keyword!"
         << endl; 
  
    cout << endl; 
    //malloc and free won't call Constructor and Destructor
    A* b = (A*)malloc(sizeof(A)); 
    cout << "Object of class A was "
         << "created using malloc()!"
         << endl; 
  
    free(b); 
    cout << "Object of class A was "
         << "deleted using free()!"
         << endl; 
  
    return 0; 
} 

// Constructor was Called!
// Object of class A was created using new operator!
// Destructor was Called!
// Object of class A was deleted using delete keyword!

// Object of class A was created using malloc()!
// Object of class A was deleted using free()!
