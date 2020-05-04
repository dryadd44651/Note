import threading
from threading import Lock
import time

class Foo:
    def __init__(self):
        self.lock1 = Lock()
        self.lock2 = Lock()
        self.lock3 = Lock()
        self.lock1.acquire()
        self.lock2.acquire()
        self.lock3.acquire()


    def first(self) -> None:
        self.lock1.release()
        with self.lock1:
            print("1")
            self.lock2.release()

    def second(self) -> None:
        with self.lock2:
            print("2")
            self.lock3.release()

    def third(self) -> None:
        with self.lock3:
            print("3")

foo = Foo()
thread_1 = threading.Thread(target=foo.first, name='T1')
thread_2 = threading.Thread(target=foo.second, name='T2')
thread_3 = threading.Thread(target=foo.third, name='T3')
thread_3.start()
time.sleep(1)
thread_2.start()
thread_1.start()
