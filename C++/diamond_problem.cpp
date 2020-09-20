class Parent{
public:
	void Function1(){
	    printf("This is parent,function1\n");
    }
};
 

class Child:public Parent{
public:
	void Function2(){
	    printf("This is Child,function2\n");
	}

} child;
 

class Child1:public Parent{
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
    c.Function1();
    // Child1 c1;
    // c1.Function1();
    GrandChild gc;
    gc.Function1();
    //Line 40: Char 8: error: member 'Function1' found in multiple base classes of different types
	return 0;
	
}


