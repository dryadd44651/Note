# OOD

## Iterator
> two features: hasNext(), next()
> pros: we don't need to care the data strcture (vector, list, hashtable...)

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

