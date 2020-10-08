# Java

*volatile keyword here makes sure that the changes made in one thread are immediately reflect in other thread*
## volatile vs synchronized:
synchronized(Mutual Exclusion): It means that only one thread or process can execute a block of code (critical section) at a time.(**atomic**)
volatile(Visibility): It means that changes made by one thread to shared data are **visible** to other threads.

Regular variable in each thread may have its own local copy of sharedVariable, but volatile doesn't.


# C++
**without optimizion file size:731(larger)**
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

# Basic Code Optimizations in C
## Unroll small loops
```
#include <stdio.h> 
int main(void) 
{ 
	int fact[5]; 
	fact[0] = 1; 

	// Overhead of managing a counter 
	// just for 4 iterations 
	// is not a good idea 
	for (int i = 1; i < 5; ++i) { 
		fact[i] = fact[i - 1] * i; 
	} 
	return 0; 
} 

```
```
#include <stdio.h> 
int main(void) 
{ 
	int fact[5] = { 1, 1, 2, 6, 24 }; 

	// Here the same work is done 
	// without counter overhead 
	return 0; 
} 

```
## Avoid calculations in loop:
```
#include <stdio.h> 
int main(void) 
{ 
	int arr[1000]; 
	int a = 1, b = 5, c = 25, d = 7; 

	// Calculating a constant expression 
	// for each iteration is not good. 
	for (int i = 0; i < 1000; ++i) { 
		arr[i] = (((c % d) * a / b) % d) * i; 
	} 
	return 0; 
} 

```
```
#include <stdio.h> 

int main(void) 
{ 
	int arr[1000]; 
	int a = 1, b = 5, c = 25, d = 7; 

	// pre calculating the constant expression 
	int temp = (((c % d) * a / b) % d); 

	for (int i = 0; i < 1000; ++i) { 
		arr[i] = temp * i; 
	} 
	return 0; 
} 

```
## Avoid pointer Dereference in loop
```
#include <stdio.h> 
int main(void) 
{ 
	int a = 0; 
	int* iptr = &a; 

	// Dereferencing pointer inside loop 
	// is costly 
	for (int i = 1; i < 11; ++i) { 
		*iptr = *iptr + i; 
	} 
	printf("Value of a : %d", a); 
	return 0; 
} 

```
```
#include <stdio.h> 
int main(void) 
{ 
	int a = 0; 
	int* iptr = &a; 

	// Dereferencing pointer outside loop 
	// and saving its value in a temp variable 
	int temp = *iptr; 

	for (int i = 1; i < 11; ++i) { 

		// performing calculations on temp variable 
		temp = temp + i; 
	} 

	// Updating pointer using final value of temp 
	*iptr = temp; 

	printf("Value of a : %d", a); 
	return 0; 
} 

```

## Use Register variables as counters of inner loops: Variables stored in registers can be accessed much faster than variables stored in memory.
```
#include <stdio.h> 
int main(void) 
{ 
	register int i = 0; 
	register int j = 0; 
	int n = 5; 

	// using register variables 
	// as counters make the loop faster 
	for (i = 0; i < n; ++i) { 
		for (j = 0; j <= i; ++j) { 
			printf("* "); 
		} 
		printf("\n"); 
	} 
	return 0; 
} 

```
## Avoid unnecessary Integer Division
```
#include <stdio.h> 
int main(void) 
{ 
	int a = 100, b = 2, c = 5; 
	// int d=a/b/c; two division operators 
	int d = a / (b * c); // single division operator 
	return 0; 
} 

```
## Multiplication and division by power of 2
*Use left shift(<<) for multiplication and right shift(>>) for division.*
```
Multiply by 6 : a= a<<1 + a<<2; 
5<<1 = 10 5<<2 = 20 10+20 = 30 = 5*6
Multiply by 7 : a= a<<3 - a;
5<<3 = 40 40-5 = 35 = 3*7 
Divide by 8 : a= a>>3; // division by power of 2
```
## Simplifying Expressions
> a*b + a*b*c + a*b*c*d ---> (a*b)*(1 + c*(1 + d)) 

## Optimization with Switch Statement
```
case c:
       common statements;
       different statements;
       common statements;
       break;
case d:
       common statements;
       different statements;
       common statements;
       break;   '
case e:
       common statements;
       different statements;
       common statements;
       break;
case f:
       common statements;
       different statements;
       common statements;
       break;
```
```
case c: 
case d: 
case e:   
case f:
  common statements;
         switch(expression);
         {
         case c:
                different statements;
                break;
         case d:
                different statements;
                break;
         case e:
                different statements;
                break;
         case f:
                different statements;
                break;
         }  /*End of switch*/
         common statements;
         break;     
```
## Prefer int to char or short
## Order of Expression Evaluation
```
 A || B  
Here first A will be evaluated, if it’s true then there is no need of evaluation of expression B. So We should prefer to have an expression which evaluates to true most of the times, at the A’s place.
A && B  
Here first A will be evaluated, if it’s false then there is no need of evaluation of expression B. So We should prefer to have an expression which evaluates to false most of the times, at the A’s place.
```

