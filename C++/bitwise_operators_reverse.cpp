#include <bitset>
int main() {
    int b = 0b11010101;
    cout<<bitset<8>(b)<<endl;
    int a = 0;
    
    for(int mask=1,shift=7;mask<=128;mask*=2,shift--){
        int tmp=(bool)(b&mask);
        a+=tmp<<shift;
    }

    cout<<bitset<8>(a)<<endl;
    
}
