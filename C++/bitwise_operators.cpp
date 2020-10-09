#include <bitset>
int main() {
    int b = 0b11010101;
    cout<<bitset<8>(b)<<endl;
    int a = 0;
    
    for(int i = 128,j = 7;i>0;i/=2,j--){
        int tmp=(bool)(b&(128/i));
        cout<<tmp<<endl;
        a+=tmp<<j;
    }
        //a+=b | i<<(32/i-1);
    cout<<bitset<8>(a)<<endl;
    
}
