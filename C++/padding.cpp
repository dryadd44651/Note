// CPP program to test 
// size of struct 
#include <iostream> 
using namespace std; 
//Data alignment: data will align to multiple of the word size (4)
//This insertion of extra bytes of memory to align the data is called data structure padding.
struct test1{ 
    short s;//2                    |ss|
    int i;  //2+4 = 6 padding -> 8 |ss--|iiii| int take compelet 4 byte (not separet)
    char c; //8+1 = 9 padding ->12 |ss--|iiii|c---|
}; 
  

struct test2{ 
    int i;  //4                    |iiii|
    char c; //4+1 = 5 padding -> 8 |iiii|c---|
    short s;//5+2 = 7 padding -> 8 |iiii|c-ss|
    //char s;
}; 

struct test3{ 
    int i;  //4                    |iiii|
    char c; //4+1 = 5 padding -> 8 |iiii|c---|
    char s; //4+1 = 5 padding -> 8 |iiii|cs--|
}; 

int main(){ 
    test1 t1; 
    test2 t2; 
    test3 t3; 
    cout << "size of int " << sizeof(int)<<" char "<<sizeof(char)<<" short "<<sizeof(short) << "\n"; 
    //size of int 4 char 1 short 2
    cout << "size of struct test1 is " << sizeof(t1) << "\n"; //12
    cout << "size of struct test2 is " << sizeof(t2) << "\n"; //8
    cout << "size of struct test3 is " << sizeof(t3) << "\n"; //8
    cout << (void *)&t2.c <<" "<<&t2.s << "\n"; //0x7ffc4abb8744 0x7ffc4abb8746
    cout << (void *)&t3.c <<" "<<(void *)&t3.s << "\n"; //0x7ffc4abb8764 0x7ffc4abb8765
    return 0; 
} 
