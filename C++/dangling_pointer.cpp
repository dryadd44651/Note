int * get_dangling_pointer()
{
    int num = 1234;
    return &num;
}
void f(){
    int num = 66666;
}
int main() {
    char *cp = NULL;
    /* ... */
    {
        char c = 'a';
        cp = &c;
        cout<<*cp<<endl;
    } /* c falls out of scope */          
    /* cp is now a dangling pointer */
    //cout<<c<<endl;//undeclared identifier 'c'
    
    //the proper way is free the pointer memory and set the pointer to NULL
    //free(cp);
    //cp = NULL;
    //cout<<*cp<<endl;//still get the value 'a'
    
    int *b = get_dangling_pointer();
    cout<<*b<<endl;//still get the 1234
    f();//call random function
    cout<<*b<<endl;//the value have been modified
    //*b is point to the address, this address is not belong to any variable(unprotected)
}
