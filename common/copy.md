# copy
## python
```
L1 = [1, 2, 3, 4, 5] 
L2 = L1[:]
L3 = L1

L1[0] = 0

print(L1) 
print(L2) 
print(L3) 
```
## java
```
public class UsesEx{ 

	public static void main(String[] args) { 
		int[] a = {3, 7, 9}; 
		int[] b;
        int[] c = new int[4];
        b = a;
        
        for(int i =0;i<a.length;i++)
            c[i] = a[i];
        a[0] = 13; 
        System.out.println( Arrays.toString(a)); 
        System.out.println( Arrays.toString(b)); 
        System.out.println( Arrays.toString(c)); 
 
	} 

} 

```
## C++
```
#include <stdio.h> 

int main() 
{ 
    int a[] = {1,2,3,4};
    int *b=a;//shallow copy
    
    int c[4];//deep copy
    for(size_t i = 0; i < 4; ++i)
        c[i] = a[i];
    int d[4];//deep copy
    memcpy(d, a, sizeof(int)*4);

    a[0] = 0;
    
    //for(const int& i : a)
    for(auto i : a)
        cout<<i;
    cout<<endl;
    for(auto i = 0;i<4;i++)
        cout<<*(b+i);
    cout<<endl;
    for(auto i : c)
        cout<<i;
    cout<<endl;
    for(auto i : d)
        cout<<i;
    cout<<endl;
	return 0; 
}

```



