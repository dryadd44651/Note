from concurrent.futures import ThreadPoolExecutor
import threading
from time import sleep
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

def divide(arr):
    size = len(arr)
    if size==1: 
        return arr[:]
    return merge(divide(arr[:size//2]),divide(arr[size//2:]))
    
    
    
def check():
    for i in range(1,len(arr)):
        if arr[i]<arr[i-1]:
            return False
    return True
arr = [random.randrange(1000) for i in range(200000)]
#normal merge sort
#arr = divide(arr)

#python sort
size = len(arr)
a = arr[:size//2]
b = arr[size//2:]
executor = ThreadPoolExecutor(max_workers=2)
start = timeit.default_timer()

#two threads
a = executor.submit(sorted,a)
b = executor.submit(sorted,b)
arr = merge(a.result(),b.result())

#one threads
#arr = merge(sorted(arr[:size//2]),sorted(arr[size//2:]))

stop = timeit.default_timer()

print('Time: ', stop - start)
print(check())

#only in very big amount of data, one thread would faster then 2 threads
# Time:  56.069326399999994 one thread
# Time:  31.3775233 2 threads

# t = threading.Thread(target=divide,args=(arr,))
# t.start()
# t.join()

