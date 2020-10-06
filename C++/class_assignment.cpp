class base { 
  public:
    int i = 0;
    virtual void f(){
        cout<<"base \n";
    }
}; 
  
class derived: public base { 
  public: 
    void f(){
        cout<<"derived\n";
    }
}; 
class base1 { 
  public:
    int i = 0;
    void f(){
        cout<<"base \n";
    }
}; 
  
class derived1: public base1 { 
  public: 
    void f(){
        cout<<"derived\n";
    }
}; 
int main(void) 
{ 
    //just like variable pointer
    //using reference & can also acheieve this result
    //declare as base(use base to express) (declare as int use int to express)
    derived *d = new derived();   
    base *b = d;
    d->f();//derived
    b->f();//derived (with virtual)(overwriten)
    d->i++;
    b->i++;
    cout<<d->i<<" "<<b->i<<endl;//shared member
    
    derived1 *d1 = new derived1();   
    base1 *b1 = d1;
    d1->f();//derived
    b1->f();//base
    d1->i++;
    b1->i++;
    cout<<d1->i<<" "<<b1->i<<endl;//shared member
    
    cout<<endl<<"non-new member"<<endl;
    derived sd;
    base sb = sd;
    sd.f();//derived
    sb.f();//base (sd and sb are independent)
    sd.i++;
    cout<<sd.i<<" "<<sb.i<<endl;//separet memory
    
    return 0; 
} 
