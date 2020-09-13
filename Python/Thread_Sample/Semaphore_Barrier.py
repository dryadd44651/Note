import threading
from threading import Barrier
from concurrent.futures import ThreadPoolExecutor
class H2O():
    def __init__(self):
        self.hsem = threading.Semaphore(2)
        self.osem = threading.Semaphore(1)
        self.b = Barrier(3)
    def hydrogen(self) -> None:
        self.hsem.acquire()
        self.b.wait()
        print("h")
        self.hsem.release()
        
    def oxygen(self) -> None:
        self.osem.acquire()
        self.b.wait()
        print("o")
        self.osem.release()

h2o = H2O()
t1 = threading.Thread(target=h2o.hydrogen)
t2 = threading.Thread(target=h2o.hydrogen)
t3 = threading.Thread(target=h2o.hydrogen)
t4 = threading.Thread(target=h2o.hydrogen)
t5 = threading.Thread(target=h2o.oxygen)
t6 = threading.Thread(target=h2o.oxygen)
t1.start()
t2.start()
t3.start()
t4.start()
t5.start()
t6.start()
# Barrier will wait until 3 thread reach b.wait()
# Semaphore(n) noly n thread will be execute in the same time
