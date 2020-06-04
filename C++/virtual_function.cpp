
 
class Parent{
public:
	
	char data[20];
	void Function1();	
	virtual void Function2();   // 这里声明Function2是虚函数
	
}parent;
 
void Parent::Function1(){
	printf("This is parent,function1\n");
}
void Parent::Function2(){
	printf("This is parent,function2\n");
}
class Child:public Parent{
	void Function1();
	void Function2();
	
} child;
 
void Child::Function1(){
	printf("This is child,function1\n");
}
void Child::Function2(){
	printf("This is child,function2\n");
}

int main(int argc, char* argv[])
 
{
	Parent *p;
	p=&child; 
	//p=&parent;
	p->Function1();//parent
	p->Function2();//child
	return 0;
	
}
