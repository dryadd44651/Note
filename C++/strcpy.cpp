void strcpy(char *s, char* t)
{
    while ((*s++ = *t++));
    // while((*s = *t) != '\0')
    // {
    //     cout<<*(s);
    //     s++;
    //     t++;
    // }
}
int main() {
    char a[128];
    char *b = "67890";
    strcpy(a,b);
    for(int i = 0;i<5;i++)
        cout<<*(a+i);
}
