//A type cast is basically a conversion from one type to another. There are two types of type conversion:
// An example of implicit conversion 
//bool -> char -> short int -> int -> unsigned int -> long -> unsigned -> long long -> float -> double -> long double
#include<stdio.h> 
int main() 
{ 
	int x = 10; // integer x 
	char y = 'a'; // character c 

	// y implicitly converted to int. ASCII 
	// value of 'a' is 97 
	x = x + y; 
	
	// x is implicitly converted to float 
	float z = x + 1.0; 

	printf("x = %d, z = %f", x, z); //x = 107, z = 108.000000
	return 0; 
} 
