#include <memory>
shared_ptr<int> MemoryAlloc()
{
    shared_ptr<int> a( new int(555) );
    cout << a.use_count() <<endl;
  return a;
}
void MemoryAlloc1()
{
    shared_ptr<int> a( new int(555) );
    //no need to delete
}
void f(){
    int num = 66666;
}
int main() {

    //shared_ptr: can be referenced by many pointer(when referenced counter ==0, delete)
    //unique_ptr: can only be referenced by one pointer(when unrefereced,delete )
    shared_ptr<int> b = MemoryAlloc();
    cout << b.use_count()<<endl;//1
    cout<<*b<<endl;
    f();
    cout<<*b<<endl;//still show 555 (not dangling)
    shared_ptr<int> c = b;
    cout << c.use_count()<<" "<<b.use_count() <<endl;//2 2
    b.reset();//release
    cout << c.use_count()<<" "<<b.use_count() <<endl;//1 0
    //c.reset()  
    
    
    int *t = new int(4);
    shared_ptr<int> a( t );
    cout<<*a<<endl;//4
    cout << a.use_count() <<endl;//1
    a.reset();//release
    cout << a.use_count() <<endl;//0
    //cout<<*a<<endl;//error
    //cout << *t <<endl;//error(heap-use-after-free)
}
