
# file1
```
/* Inside file1.c */ 
static void fun1(void) 
{ 
  puts("fun1 called"); 
} 
```

# file2
```
/* Inside file2.c  */ 
int main(void) 
{ 
  fun1();  
  getchar(); 
  return 0;   
} 
```
# compile
> gcc file2.c file1.c

> **error “undefined reference to `fun1’” . This is because fun1() is declared static in file1.c and cannot be used in file2.c.**
