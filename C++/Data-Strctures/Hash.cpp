#include <iostream>
#include <string>
#include<vector>
#include <math.h>
using namespace std;
class Hash{
    bool *exit;
    string *table;
    int size = 31;
    int num = 0;
    public:
        Hash(){
            init();
        }
        void init(){
            exit = new bool [size]();
            table = new string [size]();
            num = 0;
        }
        int getIdx(string s){//0 read 1 write
            int val = str2hash(s);
            int idx = val;
            int count = 2;
            while(exit[idx]!=0){
                if(table[idx]==s)
                    break;
                idx = (val+pow(count,2));
                idx = idx % size;
                count++;
                
            }
            return idx;
        }
        void rehash(){
            string *tmp = new string[num]();
            int j=0;
            for(int i =0;i<size;i++){
                if(exit[i]){
                    tmp[j]=table[i];
                    //cout<<tmp[j]<<endl;
                    j++;
                }
            }
            size*=2;
            int n = num;
            init();
            for(int i =0;i<n;i++){
                set(tmp[i]);
            }
        }
        void set(string s){
            num++;
            if(num/size>0.5){
                cout<<"rehash"<<endl;
                rehash();
            }
            int idx = getIdx(s);
            table[idx] = s;
            exit[idx] = 1;
        }
        bool get(string s){
            int idx = getIdx(s);
            return exit[idx];
        }
        void show(){
            for(int i =0;i<size;i++){
                if(exit[i])
                    cout<<i<<" : "<<table[i]<<", ";
                else
                    cout<<i<<", ";
            }
            cout<<endl;
        }
    
        int str2hash(string &x) { 
            int hashVal = 0; 
            for (int i = 0; i < x.length(); i++)
                hashVal += x[i]; 
            return (hashVal % size); 
        } 
};



int main() {
    string a[] ={"aaa", "bbb", "cccc", "ddddd", "eeeeee", "FFFFF","ggggg ggg", "EEEE", "ADDD","S S","IIII", "TTT", "QQQQQQ", "KKKK", "XXXX","jjjjj", "VVVV","YYYYYY","ZZZ","BtB H"}; 
    Hash hash;
    for(auto s:a)
        hash.set(s);

    hash.show();

    
}
