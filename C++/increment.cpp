int main() {
    int i = 1;
    int j = i++;
    cout<<j<<endl;
    cout<<i<<endl;

    i = 1;
    j = ++i;
    cout<<j<<endl;
    cout<<i<<endl;
}
//output
//1
//2
//2
//2
