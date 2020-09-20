class Parent{
public:
	void Function1(){
	    printf("This is parent,function1\n");
    }
} Mom,Dad;
 


int main(int argc, char* argv[])
 
{
    Parent p;
    p.Function1();
    Mom.Function1();
    Dad.Function1();
    return 0;
	
}
