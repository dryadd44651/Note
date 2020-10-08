# Java

*volatile keyword here makes sure that the changes made in one thread are immediately reflect in other thread*
## volatile vs synchronized:
synchronized(Mutual Exclusion): It means that only one thread or process can execute a block of code (critical section) at a time.(**atomic**)
volatile(Visibility): It means that changes made by one thread to shared data are **visible** to other threads.

Regular variable in each thread may have its own local copy of sharedVariable, but volatile doesn't.


# C++
**without optimization file size:731(larger)**
```
/* Compile code without optimization option */
#include <stdio.h> 
int main(void) 
{ 
	const int local = 10; 
	int *ptr = (int*) &local; 

	printf("Initial value of local : %d \n", local); 

	*ptr = 100; 

	printf("Modified value of local: %d \n", local); 

	return 0; 
} 
  [narendra@ubuntu]$ gcc volatile.c -o volatile –save-temps
  [narendra@ubuntu]$ ./volatile
  Initial value of local : 10
  Modified value of local: 100
  [narendra@ubuntu]$ ls -l volatile.s
  -rw-r–r– 1 narendra narendra 731 2016-11-19 16:19 volatile.s
  [narendra@ubuntu]$
```

**compiler does optimization and ignores the instructions which try to change value of const object. Hence value of const object remains same.**
**with optimizion file size:626(smaller)**
```
/* Compile code with optimization option */
#include <stdio.h> 

int main(void) 
{ 
	const int local = 10; 
	int *ptr = (int*) &local; 

	printf("Initial value of local : %d \n", local); 

	*ptr = 100; 

	printf("Modified value of local: %d \n", local); 

	return 0; 
} 
  [narendra@ubuntu]$ gcc -O3 volatile.c -o volatile –save-temps
  [narendra@ubuntu]$ ./volatile
  Initial value of local : 10
  Modified value of local: 10
  [narendra@ubuntu]$ ls -l volatile.s
  -rw-r–r– 1 narendra narendra 626 2016-11-19 16:21 volatile.s
```
## Even we complie the code with optimization option, the local still not optimized.
**with optimizion file size:711**
```
/* Compile code with optimization option */
#include <stdio.h> 
  
int main(void) 
{ 
    const volatile int local = 10; 
    int *ptr = (int*) &local; 
  
    printf("Initial value of local : %d \n", local); 
  
    *ptr = 100; 
  
    printf("Modified value of local: %d \n", local); 
  
    return 0; 
} 
  [narendra@ubuntu]$ gcc -O3 volatile.c -o volatile –save-temp
  [narendra@ubuntu]$ ./volatile
  Initial value of local : 10
  Modified value of local: 100
  [narendra@ubuntu]$ ls -l volatile.s
  -rw-r–r– 1 narendra narendra 711 2016-11-19 16:22 volatile.s
  [narendra@ubuntu]$
```

