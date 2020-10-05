int main() {
    int a = 10; 
    void *ptr = &a; 
    cout<<ptr<<" "<<&a<<endl;
    cout<<*(int*)ptr<<endl;
    
    int b[10] = {1, 2, 3, 4, 5, 6, 7}; 
    void *ptr1 = b; 
    ptr1 = (int*)ptr1+1;     
    cout<<*(int*)ptr1<<endl;
    return 0; 
        
}
