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
# Macro vs inline
** both can speed up(more memory use) **
```
#include <stdio.h> 
//Macro (can be int,float, double) (just replace text)
#define SQUARE(x) (x * x)
//inline
inline int square(int x) {
  return x * x;
}
int main() 
{ 
	//inline executed in compile (function ->inline in main)
    cout<<square(3+2)<<endl;
    //Macro executed in preprocess
    //simplely replace x by 3+2
    //3+2*3+2 = 3+6+2 = 11
    cout<<SQUARE(3+2)<<endl;
	return 0; 
} 

```
# C’s program building process
1. Preprocessing: include-files, conditional compilation instructions and macros.
2. Compilation: output of the preprocessor, source code => assembler source code
3. Assembly: assembler source code => assembly listing with offsets in object file
4. Linking: object files, libraries => executable file

# CPU scheduling
1. Preemptive Scheduling: 
>>  Round Robin (RR),Shortest Remaining Time First (SRTF), Priority (preemptive version)
2. Non-Preemptive Scheduling: 
>>  Shortest Job First (SJF basically non preemptive) and Priority (non preemptive version), First Come First Serve
