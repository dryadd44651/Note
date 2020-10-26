from concurrent.futures import ThreadPoolExecutor
import threading
from time import sleep
# executor = ThreadPoolExecutor(max_workers=2)
# a = executor.submit(wait_on_a)
# b = executor.submit(wait_on_b))
# print(a.result())
# print(b.result())


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
arr = [randrange(1000) for i in range(200000)]
#arr = divide(arr)
size = len(arr)
a = arr[:size//2]
b = arr[size//2:]
executor = ThreadPoolExecutor(max_workers=2)
# a = executor.submit(sorted,a)
# b = executor.submit(sorted,b)

# arr = merge(a.result(),b.result())

arr = merge(sorted(arr[:size//2]),sorted(arr[size//2:]))
print(check())

# Finished in 1648 ms one thread
# Finished in 1584 ms 2 thread

# t = threading.Thread(target=divide,args=(arr,))
# t.start()
# t.join()

