from concurrent.futures import ThreadPoolExecutor
import threading
from threading import Lock
import random
import timeit

def merge(a,b):
    c = []
    while a and b:
        if a[0]<b[0]:
            c.append(a.pop(0))
        else:
            c.append(b.pop(0))
    c.extend(a or b)
    return c
executor = ThreadPoolExecutor(max_workers=2000)
def divide(arr):
    size = len(arr)
    if size==1: 
        return arr[:]

    return merge(divide(arr[:size//2]),divide(arr[size//2:]))
    
def worker():
    while len(arr)!=1:
        
        
        if len(arr)<=1: return
        a = arr.pop(0)
        b = arr.pop(0)
        #print(0)
            
        c = merge(a,b)
        arr.append(c)
        #print(1)
    if lock.locked():
        lock.release()

def check():
    for i in range(1,len(arr)):
        if arr[i]<arr[i-1]:
            return False
    return True
arr = [[random.randrange(1000)] for i in range(50000)]
lock = Lock()
start = timeit.default_timer()

# executor.submit(worker)
# executor.submit(worker)
threading.Thread(target=worker).start()
threading.Thread(target=worker).start()
threading.Thread(target=worker).start()


lock.acquire()
with lock:
    pass
stop = timeit.default_timer()
print('Time: ', stop - start)
print(check())

# one thread Time:  10.2630561
# three thread Time:  7.0809538
