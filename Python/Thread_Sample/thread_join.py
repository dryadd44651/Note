import logging
import threading
import time

def T1_job():
    print("T1 start\n")
    time.sleep(3)
    print("T1 finish\n")

def T2_job():
    print("T2 start\n")
    time.sleep(1)
    print("T2 finish\n")

thread_1 = threading.Thread(target=T1_job, name='T1')
thread_2 = threading.Thread(target=T2_job, name='T2')
thread_1.start()
thread_2.start()
thread_2.join()
#thread_2 join the main thread (main thread will wait until thread_2 finish) 
print("all done\n")
# T1 start

# T2 start

# T2 finish

# all done

# T1 finish
