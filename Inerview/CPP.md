# Storage Classes
1. auto	It is a default storage class.
2. extern	It is a global variable.(cross file)
3. static	The lifespan of a static variable is in the entire program code.(only can be acessed in same file)
4. register	It is a variable which is stored inside a Register. (quick access)

"static" cannot be accessed from any other file. Thus, prefixes “extern” and “static” cannot be used in the same declaration.

# Dynamic Memory Allocation
```
int main() 
{ 
   // Below variables are allocated memory 
   // dynamically. 
   int *ptr1 = new int; 
   int *ptr2 = new int[10]; 
  
   // Dynamically allocated memory is 
   // deallocated  
   delete ptr1; 
   delete [] ptr2; 
} 
```
