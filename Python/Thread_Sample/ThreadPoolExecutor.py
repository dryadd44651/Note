from concurrent.futures import ThreadPoolExecutor
from time import sleep
def task(message,n):
    sleep(n/10)
    print(n)
    return message

def main():
    executor = ThreadPoolExecutor(3)
    task3 = executor.submit(task, ("Completed"),3)
    task2 = executor.submit(task, ("Completed"),2)
    task1 = executor.submit(task, ("Completed"),1)
    task0 = executor.submit(task, ("Completed"),0)
    print(task1.done())
    sleep(2/10)
    print(task1.done())
if __name__ == '__main__':
    main()
# task3 come first, but task1 print first
# task0 print after task1, because of the number of thread
# 0
# True
# 1
# 2
# True
# 3
