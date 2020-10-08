# Java

*volatile keyword here makes sure that the changes made in one thread are immediately reflect in other thread*
## volatile vs synchronized:
synchronized(Mutual Exclusion): It means that only one thread or process can execute a block of code (critical section) at a time.(**atomic**)
volatile(Visibility): It means that changes made by one thread to shared data are **visible** to other threads.

Regular variable in each thread may have its own local copy of sharedVariable, but volatile doesn't.


# C++

