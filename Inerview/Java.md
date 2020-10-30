

## String vs StringBuilder vs StringBuffer
> String: immutable(new object)(extra memory)(more time on Garbage Collection)

> StringBuilder: mutable, more efficient than StringBuffer, but not thread safe

> StringBuffer: mutable, thread safe

https://www.geeksforgeeks.org/string-vs-stringbuilder-vs-stringbuffer-in-java/


## final vs finally vs finalize
### final
> final with Variables : The value of variable cannot be changed once initialized.(like const in C++)

> final with Class : The class cannot be subclassed.

> final with Method : The method cannot be overridden by a subclass.

> finally: in try/catch block and guarantees that a section of code will be executed, even if an exception is thrown.

> finalize: similar to(destructor in C++), but finalize only execute in Garbage Collection
```
Bye m = new Bye(); 
// Calling finalize method Explicitly. 
m.finalize(); 
m = null; 
// Requesting JVM to call Garbage Collector method 
System.gc(); 
```
https://www.geeksforgeeks.org/g-fact-24-finalfinally-and-finalize-in-java/
## throw vs throws
> throw the exception manually

>throws the exception if happen
```
void Demo() throws ArithmeticException, NullPointerException 
{ 
// Statements where exceptions might occur. 
throw new ArithmeticException(); 
} 
```
https://www.geeksforgeeks.org/difference-between-throw-and-throws-in-java/
