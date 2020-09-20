class Parent{
public:
	
	char data[20];
	void Function1();	
	virtual void Function2();//virtual function (with base case) (can be redefined in derived class)
	virtual void Function3() = 0;//pure virtual function(must be be defined in derived class)
};
 
void Parent::Function1(){
	printf("This is parent,function1\n");
}
void Parent::Function2(){
	printf("This is parent,function2\n");
}
class Child:public Parent{
public:
	void Function1();
	void Function2();
	void Function3();
} child;
 
void Child::Function1(){
	printf("This is child,function1\n");
}
void Child::Function2(){
	printf("This is child,function2\n");
}
void Child::Function3(){
	printf("This is child,function3\n");
}

class Child1:public Parent{
public:
	void Function1();
	void Function2();
	void Function3();
} child1;
 
void Child1::Function1(){
	printf("This is child1,function1\n");
}
void Child1::Function2(){
	printf("This is child1,function2\n");
}
void Child1::Function3(){
	printf("This is child1,function3\n");
}

int main(int argc, char* argv[])
 
{
	Parent *p;
	p=&child; 
    //p=&parent;//this is wrong parent contains pure virtual Function(abstract class)
	printf("\nparent = &child\n\n");
	p->Function1();//parent
	p->Function2();//child
    p->Function3();//child
    //p can be assigned to child or child dynamically
    printf("\nparent = &child1\n\n");
    p=&child1;
    
    p->Function1();//parent
	p->Function2();//child
    p->Function3();//child
    
    printf("\nchild = &child \n\n");
    //all fuction is child
    Child *c;
	
    c=&child;
    c->Function1();//child
	c->Function2();//child
    c->Function3();//child
	return 0;
	
}

// parent = &child

// This is parent,function1
// This is child,function2
// This is child,function3

// parent = &child1

// This is parent,function1
// This is child1,function2
// This is child1,function3

// child = &child 

// This is child,function1
// This is child,function2
// This is child,function3

