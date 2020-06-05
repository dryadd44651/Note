# c++
```
#include <stdio.h> 
void fun(int &a){
    a+=1;
}
void fun(int *a){
    *a+=1;
}
int main() 
{ 
    int i = 0;
    fun(i);
    fun(&i);
    cout<<i<<endl;
	return 0; 
}

```
# java
```
public class Tester{
    
    public static void main(String[] args){
        IntWrapper a = new IntWrapper(0);
        int[] b = {0};
        fun(a);
        fun(b);
        System.out.println(a.val);
        System.out.println(b[0]);
    }
    public static void fun(IntWrapper a) {//obj will pass by reference
        a.val++;
    }
    public static void fun(int[] a) {//array will pass by pointer
        a[0]++;
    }

}
class IntWrapper {
    public int val;
    public IntWrapper(int val){ this.val = val;}
}
```
# python
```
class intWrapper:
    def __init__(self,val):
        self.val = val
def add(a):
    a[0]+=1
def add1(a):
    a.val+=1

a=[0]
b = intWrapper(0)
print(id(a),id(b))
add(a)

add1(b)
print(a[0],b.val)

print(id(a),id(b))
#immutable
c = "123"
print(id(c))
c+="4"
print(id(c))
#id(c) change due to string is immutable(can't be changeg)


L1 = [1, 2, 3, 4, 5] 
L2 = [1, 2, 3, 4, 5] 
  
print(L1 == L2) #val is same
print(L1 is L2) #address is different

```
```
139656324755712 139656325412464
1 1
139656324755712 139656325412464
139656334386032
139656299797168
True
False
```
