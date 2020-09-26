// condition_variable_any::notify_one
#include <iostream>           // std::cout
#include <thread>             // std::thread
#include <mutex>              // std::mutex
#include <condition_variable> // std::condition_variable_any

std::mutex mtx;
std::condition_variable  cv;

void run (int i) {
    cout <<i<<endl;
    {//this scope is critical section(synchronized)
        unique_lock<mutex> lk(mtx);
        for (int j=0; j<5; ++j) {
            std::this_thread::sleep_for(10ms);
            cout <<"T"<<i<<endl;
        }
    }
}


int main ()
{
    std::thread t[5];
    
    for (int i=0; i<5; ++i) {
        t[i] = std::thread(run,i);
       
    }
    cout<<"main"<<endl;
    for (int i=0; i<5; ++i) {
        t[i].join();
    }
    return 0;
}


// 0
// 1
// 2
// 3
// 4
// main
// T0
// T0
// T0
// T0
// T0
// T1
// T1
// T1
// T1
// T1
// T2
// T2
// T2
// T2
// T2
// T3
// T3
// T3
// T3
// T3
// T4
// T4
// T4
// T4
// T4
