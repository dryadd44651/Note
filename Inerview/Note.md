# OOD

## Iterator
> two features: hasNext(), next()
> pros: we don't need to care the data strcture (vector, list, hashtable...), lazy load(don't need to load all data into memory)

## Process vs Thread

Porcess can access shared data
conmuicate: files, sockets, pipes(special memory)
1 process can have muti-thread
cost more time, memory

Thread: lightweight process
access shared data
has own stack, cache(thread local storage

example: chrome tap(each tap is a process)
one tap crash won't effect another

## polymorphism
animal: run()
dog, cat, elephant inherit animal
They all run different ways.

## Synchronization
when: shared data (critical section)
con: synchroized-> sequential

## Mutex vs Semaphore
Mutex: one lock
Semaphore: multi keys(how many thread can run concurrently

## Atomic
ex: 
i = 1
thread1 i++
thread2 i++
if not Atomic: i=2 (wrong)
if Atomic: i=3 (correct)
solution:
Java: AtomicInteger

## Thread Local Storage
thread's private stroage(need to release

## Garbage Collection
Mark & sweep
stack: roots object
1. start from root to find all referece in heap and "mark" as refereced
2. Mark compact: create new memory space and copy all mark object
3. clean old memory place
Generation: every time object survives-> increase generation
yong generation->garbage collection frequently
old generation->garbage collection not frequently
Permanent generation->garbage collection rarely

## threadpool
control thread numbers
reuse threads(reduce creating thread)
