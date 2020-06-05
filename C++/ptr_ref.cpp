int main() {
    int a[] = {1,2,3,4};
    //*b = address a
    //pointer can only = address
    int* b = a;
    //reference c = val a
    int &c = *a;
    int d = *a;//d = 1
    int* e = b;
    //1
    cout<<*a<<endl;
    cout<<*b<<endl;
    cout<<c<<endl;
    cout<<d<<endl;
    cout<<*e<<endl;
    cout<<"address"<<endl;
    //0x7fffdf6194a0
    cout<<a<<endl;
    cout<<b<<endl;
    cout<<&c<<endl;
    //0x7fffdf6194c0
    cout<<&d<<endl;
    // * get val
    // & get address
}
