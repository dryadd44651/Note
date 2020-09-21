import threading
class solution:
    def __init__(self):
        self.c = 0
        self.nums = 1
    def worker(self):
        print(self.c,self.nums)
        if self.c>=50:return
        self.c+=randrange(0, 3)
        t = threading.Thread(target=self.worker)
        self.nums+=1
        t.start()
        t.join()
        
s = solution()
s.worker()
