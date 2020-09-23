
#include <iostream>
using namespace std;

//the number in union(mark,num) share same memory
//pron: save memory
union test
{
    float fnum;
    char mark;
    long num;
    
}a,b;
 
int main()
{
    // cout<<a<<endl; // wrong
    a.mark = 'b';
    b.mark = 'a';
    cout<<"a.mark: "<<a.mark<<endl; // 输出'b'
    cout<<"a.num : "<<a.num<<endl; // 98 字符'b'的ACSII值
    
    cout<<"b.mark: "<<b.mark<<endl; // 输出'b'
    cout<<"b.num : "<<b.num<<endl; // 98 字符'b'的ACSII值
    cout<<"b.fnum: "<<b.fnum<<endl; // error number

    a.num = 100;
    cout<<"a.mark: "<<a.mark<<endl; // 输出'd'
    cout<<"a.num : "<<a.num<<endl; // 字符'd'的ACSII值
    
    cout<<"size of a    : "<<sizeof(a)<<endl;
    cout<<"size of b    : "<<sizeof(b)<<endl;
    cout<<"size of test : "<<sizeof(test)<<endl;
    cout<<"size of long : "<<sizeof(long)<<endl;
    cout<<"size of char : "<<sizeof(char)<<endl;
    cout<<"size of float: "<<sizeof(float)<<endl;



    return 0;

} 
// a.mark: b
// a.num : 98
// b.mark: a
// b.num : 97
// b.fnum: 1.35926e-43
// a.mark: d
// a.num : 100
// size of a    : 8
// size of b    : 8
// size of test : 8
// size of long : 8
// size of char : 1
// size of float: 4
