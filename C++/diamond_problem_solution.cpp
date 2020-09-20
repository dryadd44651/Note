class Parent{
public:
	void Function1(){
	    printf("This is parent,function1\n");
    }
};
 

class Child:public virtual Parent{
public:
	void Function2(){
	    printf("This is Child,function2\n");
	}

} child;
 

class Child1:public virtual Parent{
public:
	void Function1(){
	    printf("This is Child1,function1\n");
	}
} ;
 
class GrandChild:public Child,public Child1{
public:
	// void Function1(){
	//     printf("This is GrandChild,function1\n");
	// }
};

int main(int argc, char* argv[])
 
{
    Child c;
    c.Function1();//parent
    Child1 c1;
    c1.Function1();//parent
    GrandChild gc;
    gc.Function1();//Child1
	return 0;
	
}
//use the virtual class to avoid multiple inheritances
//GrandChild fucntion1 will inherit from child1 (child is virtual from the parent)
//we still need to avoid child and child1 having the same function!

//This is parent,function1
//This is Child1,function1
//This is Child1,function1
