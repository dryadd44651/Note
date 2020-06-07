#include <stdio.h> 
bool myfunction (int i,int j) { return (i<j); }
int main() 
{ 
    //string
    string str = "123";
    string str1;
    string &str2 = str;
    str1 = str;
    str +="4";
    cout<<str<<endl;
    cout<<str1<<endl;
    cout<<str2<<endl;
    cout<<str1.size()<<endl;
    cout<<str2.length()<<endl;
    str.insert(0,"0");
    str.erase(0,1);
    std::size_t found = str.rfind("4");
    if (found!=std::string::npos)
        str.replace(found,1,"456");
    cout<<str<<endl;
    //stack
    std::stack<int> mystack;

    for (int i=0; i<5; ++i) mystack.push(i);

    std::cout << "Popping out elements...";
    while (!mystack.empty())
    {
        std::cout << ' ' << mystack.top();
        mystack.pop();
    }
    std::cout << '\n';
    //queue
    std::queue<int> myqueue;
    myqueue.push(1);
    myqueue.push(2);
    myqueue.push(3);
    cout<<myqueue.front()<<myqueue.back()<<endl;
    myqueue.pop();
    cout<<myqueue.front()<<myqueue.back()<<endl;
    //heap
    int myints[] = {10,20,30,5,15};
    std::vector<int> v(myints,myints+5);

    std::make_heap (v.begin(),v.end());
    for (int i=0; i<v.size(); ++i)
        cout<<v[i]<<',';
    cout<<endl;
    std::cout << "initial max heap   : " << v.front() << '\n';

    std::pop_heap (v.begin(),v.end()); v.pop_back();
    std::cout << "max heap after pop : " << v.front() << '\n';

    v.push_back(99); std::push_heap (v.begin(),v.end());
    std::cout << "max heap after push: " << v.front() << '\n';

    std::sort_heap (v.begin(),v.end());

    std::cout << "final sorted range :";
    for (unsigned i=0; i<v.size(); i++)
    std::cout << ' ' << v[i];

    std::cout << '\n';
    
    //map
    std::map<char,int> mymap;

    // first insert function version (single parameter):
    mymap.insert ( std::pair<char,int>('a',100) );
    mymap.insert ( std::pair<char,int>('z',200) );
    std::cout << "mymap contains:\n";
    for (auto it=mymap.begin(); it!=mymap.end(); ++it)
        std::cout << it->first << " => " << it->second << '\n';
    cout<<mymap['a']<<endl;

    //vector and sort
    //contiguosly store(array base), read fast, insert slow
    vector<int> vec = {10,20,30,5,15};
    //sort vector with lambda function
    //auto compare = [](int a,int b){return a>b;};
    sort(vec.begin(),vec.end(),[](int a,int b){return a>b;});
    for (int i=0; i<vec.size(); i++)
        cout << vec[i]<<' ';
    cout<<endl;
        
    
    //Double ended queue(linked list base)
    //list + vector = read,insert fast
    //need more memory
    deque<int> mydeque = {10,20,30,5,15};
    sort(mydeque.begin(),mydeque.end());
    for (int i=0; i<mydeque.size(); i++)
        cout << mydeque[i]<<' ';
    cout<<endl;
    //set
    std::set<int> myset;
    myset.insert(1);
    myset.insert(2);
    myset.insert(3);
    myset.insert(3);
    for(auto i : myset)
        cout<<i;
    cout<<endl;
    int myints1[] = {10,20,30,30,20,10,10,20};
    std::vector<int> myvec(myints1,myints1+8);           // 10 20 30 30 20 10 10 20

    std::sort (myvec.begin(), myvec.end());                // 10 10 10 20 20 20 30 30

    std::vector<int>::iterator low,up;
    low=std::lower_bound (myvec.begin(), myvec.end(), 20); //          ^
    up= std::upper_bound (myvec.begin(), myvec.end(), 20); //                   ^
    cout<<binary_search (myvec.begin(), myvec.end(), 20)<<endl;
    std::cout << "lower_bound at position " << (low- myvec.begin()) << '\n';
    std::cout << "upper_bound at position " << (up - myvec.begin()) << '\n';

}












