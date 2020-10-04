int main() {
    int a = 10; 
    void *ptr = &a; 
    //printf("%d", *ptr); 
    cout<<ptr<<" "<<&a<<endl;
    //cout<<(int)*ptr; void cant cast to int
    return 0; 
        
}
