#include <iostream>           // std::cout
#include <thread>             // std::thread
#include <mutex>              // std::mutex
#include <condition_variable> // std::condition_variable_any

std::mutex mtx,sem;
int nums = 2;
std::condition_variable  cv;


void run (int i) {
    bool wait = false;
    {unique_lock<mutex> lk(mtx);
        if(nums==0){
            wait = true;
            
        }
        else
            nums--;  
        cout <<"T:"<<i<<" nums: "<<nums<<" wait: "<<wait<<endl;
    }
    if(wait){
        sem.lock();
        cout<<i<<" thread is locking"<<endl;
    }
        
    
    for (int j=0; j<5; ++j) {
         std::this_thread::sleep_for(50ms);
         cout <<"T:"<<i<<endl;
    }
    {unique_lock<mutex> lk(mtx);
        nums++;
        sem.unlock();
        cout<<"some thread is unlocking"<<endl;
    }
    
    //cv.notify_one();
}


int main ()
{
    std::thread t[5];
    //the sem lock is not locked
    //lock the sem
    sem.lock();
    for (int i=0; i<5; ++i) {
        t[i] = std::thread(run,i);
    }
    
    cout<<"main"<<endl;
    for (int i=0; i<5; ++i) {
        t[i].join();
    }
    return 0;
}

// T:0 nums: 1 wait: 0
// T:1 nums: 0 wait: 0
// T:2 nums: 0 wait: 1
// T:3 nums: 0 wait: 1
// main
// T:4 nums: 0 wait: 1
// T:T:10

// T:1
// T:0
// T:1
// T:0
// T:1
// T:0
// T:1
// T:some thread is unlocking
// 20 thread is locking

// some thread is unlocking
// 3 thread is locking
// T:2
// T:3
// T:2
// T:3
// T:2
// T:3
// T:2
// T:3
// T:2
// some thread is unlocking
// T:3
// some thread is unlocking
// 4 thread is locking
// T:4
// T:4
// T:4
// T:4
// T:4
// some thread is unlocking
