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
// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        String txt = "Please locate where 'locate' occurs!";
        System.out.println(txt.indexOf("locate")); // Outputs 7
        txt = "We are the so-called \"Vikings\" from the north.";
        String myStr = "Hello";
        System.out.println(myStr.contains("Hel"));   // true
        System.out.println(myStr.contains("e"));     // true
        System.out.println(myStr.contains("Hi"));    // false
        //Find the first occurrence of the letter "e" in a string, starting the search at position 5:
        myStr = "Hello planet earth, you are a great planet.";
        System.out.println(myStr.indexOf("e", 5));
        //Return a new string where all "l" characters are replaced with "p" characters:
        myStr = "Hello";
        System.out.println(myStr.replace('l', 'p'));
        myStr = "Hello";
        System.out.println(myStr.replaceAll("l", "p"));
        myStr = "Hello";
        System.out.println(myStr.replaceFirst("l", "p"));
        String str = "geekss@for@geekss"; 
        String[] arrOfStr = str.split("@", 3); 
  
        for (String a : arrOfStr) 
            System.out.println(a); 
        
        str= new String("quick brown fox jumps over the lazy dog");
        System.out.println("Substring starting from index 15:");
        System.out.println(str.substring(15));
        System.out.println("Substring starting from index 15 and ending at 20:");
        System.out.println(str.substring(15, 20));
        
        
        ArrayList<Integer> myNumbers = new ArrayList<Integer>();
        myNumbers.add(33);
        myNumbers.add(15);
        myNumbers.add(20);
        myNumbers.add(34);
        myNumbers.add(8);
        myNumbers.add(12);

        Collections.sort(myNumbers);  // Sort myNumbers

        for (int i : myNumbers)
            System.out.println(i);
        System.out.println("sub");
        ArrayList<Integer> sub = new ArrayList<Integer>(myNumbers.subList(2, 4)); 
        for (int i : sub)
            System.out.println(i);
        System.out.println("------");
        myNumbers.set(0,-1);
        System.out.println(myNumbers.get(0));
        myNumbers.remove(0);
        System.out.println(myNumbers.get(0));
        System.out.println(myNumbers.contains(10));
        System.out.println(myNumbers.indexOf(20));
        
    }
}
```
