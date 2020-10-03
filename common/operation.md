```
#include<stdio.h>

int main(void) {
    std::string str="We think in generalities, but we live in details.";
    std::string str2 = str.substr (3,5);     // "think"
    std::size_t pos = str.find("live");      // position of "live" in str
    std::string str3 = str.substr (pos);     // get from "live" to the end
    cout<<pos<<endl;
    std::cout << str2 << ' ' << str3 << '\n';
    str.pop_back();
    str.append("!!");
    str.erase(str.begin(),str.begin()+2);
    str.insert(0,"They");
    pos = str.find("we");
    str.replace(pos,2,"They");//index, size
    cout<<str<<endl;
    //http://www.cplusplus.com/reference/string/string/append/
    vector<int> a = {1,2,3,4,5,6,7,8,9};
    vector<int> sub = vector<int>(a.begin() + 3, a.end());
    for (auto& i: sub)
        std::cout << i << ' ';
    return 0;
}
```
