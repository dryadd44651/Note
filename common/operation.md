# C++
```
#include<stdio.h>
template <typename T>
string join(const T& v, const string& delim) {
    ostringstream s;
    for (const auto& i : v) {
        if (&i != &v[0]) {
            s << delim;
        }
        s << i;
    }
    return s.str();
}
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
    vector<int> b = {10,11,12,};
    vector<int> sub = vector<int>(a.begin() + 3, a.end());
    for (auto& i: sub)
        std::cout << i << ' ';
    cout<<endl;
    a.insert(a.end(),b.begin(),b.end());
    for (auto& i: a)
        std::cout << i << ' ';
    cout<<endl;
    string s1 = join(a, "-");
    cout<<s1<<endl;
    return 0;
}
}
```

# Python
```
s = "123456789"
print(s)
print(s[2:4])
print(s.find('5'))
arr = [i for i in range(3,13)]
arr.insert(4,'-')
print(arr)
arr.pop(4)
print(arr)
print(arr.index(4))

print('-'.join([str(a) for a in arr]))
print(list(map(lambda x: 'ten' if x == 10 else x, arr)))
```
# Java
```
```
