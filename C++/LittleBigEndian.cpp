int main() 
{ 
    // 0x00D 0x00C 0x00B 0x00A <-
    //Little endian: 0000 0000, 0000 0001 => 1
    // 0x00A 0x00B 0x00C 0x00D ->
    //Big endian   : 0000 0001, 0000 0000=>256
    unsigned char arr[2] = {0x01, 0x00}; 
    unsigned short int x = *(unsigned short int *) arr; 
    printf("%d\n", x); 
    printf("%d %d\n", &arr[0],&arr[1]);//arr[0] < arr[1] (always)
    if (x==1)     
       printf("Little endian\n"); 
    else
       printf("Big endian\n");
   
   //little      [0001] 0000 0000 0000
   //big         [0000] 0000 0000 0001
   //mem address    1    2    3    4
   unsigned int i = 1; 
   char *c = (char*)&i; 
   if (*c)     
       printf("Little endian"); 
   else
       printf("Big endian"); 
   //little: low address store low byte
   //big: high address store low byte
   return 0; 
} 
//Little endian
//{0x00, 0x01} => 0000 0001, 0000 0000 =>256
//  1     2
//Big endian
//  2     1   => 0000 0000, 0000 0001 =>1

//Big endian
//{0x01, 0x00} => 0000 0001,0000 0000 =>256
//   2    1
//Little endian
//   1    2    => 0000 0000,0000 0001 =>1
