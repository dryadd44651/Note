int main() 
{ 
    // 0x00D 0x00C 0x00B 0x00A <-
    //Little endian: 00 01 => 1
    // 0x00A 0x00B 0x00C 0x00D ->
    //Big endian   : 01 00 =>255
    unsigned char arr[2] = {0x01, 0x00}; 
    unsigned short int x = *(unsigned short int *) arr; 
    printf("%d\n", x); 
    printf("%d %d\n", &arr[0],&arr[1]);//arr[0] < arr[1] (always)
    if (x==1)     
       printf("Little endian"); 
    else
       printf("Big endian");
    return 0; 
} 
