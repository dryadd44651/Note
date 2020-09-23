int main() 
{ 
    //Little endian: 00 01 => 1
    //Big endian   : 01 00 =>255
    unsigned char arr[2] = {0x01, 0x00}; 
    unsigned short int x = *(unsigned short int *) arr; 
    printf("%d\n", x); 
    if (x==1)     
       printf("Little endian"); 
    else
       printf("Big endian");
    return 0; 
} 
