#include <stdio.h> 
bool cmp(int a,int b){
    return a>b;
}
int main() 
{ 
	std::array<int, 10> s = {5, 7, 4, 2, 8, 6, 1, 9, 0, 3};  
    // std::sort(s.begin(), s.end(), [](int a, int b) {
    //     return a > b;   
    // });
    std::sort(s.begin(), s.end(),cmp );
    for (auto a : s) {
        std::cout << a << " ";
    } 
    std::cout << '\n';
	return 0; 
}
