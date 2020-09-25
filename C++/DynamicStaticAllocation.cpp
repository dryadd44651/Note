#include <iostream> 
using namespace std; 
  
class construct { 
public: 
    int a; 
  
    // Default Constructor 
    construct(int val){ 
        a = val;
        cout<<"constrct "<<a <<endl;
    }
    ~construct(){ 
        cout<<"~constrct "<<a <<endl;
    }
    
}; 
  
int main() 
{ 
    // Default constructor called automatically 
    // when the object is created 
    construct *c = new construct(1);//dynamically allocate
    cout<<c->a <<endl;
    cout<<"main" <<endl;
    delete c;//new should be delete manually
    //cout<<c->a <<endl; //error (c had been deleted)
    construct con(2);//statically allocate
    cout<<con.a <<endl;
    //end of program deconstructor called automatically 
    return 0; 
} 
// constrct 1
// 1
// main
// ~constrct 1
// constrct 2
// 2
// ~constrct 2
