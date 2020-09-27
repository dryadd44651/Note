#include <iostream>           // std::cout
#include <thread>             // std::thread
#include <mutex>              // std::mutex
#include <condition_variable> // std::condition_variable_any

std::mutex mtx,latch;
int nums = 3;
std::condition_variable  cv;


void run (int i) {
    
    for (int j=0; j<5; ++j) {
        std::this_thread::sleep_for(50ms);
        {unique_lock<mutex> lk(mtx);
            cout <<"T:"<<i<<endl;
        }
    }
    {unique_lock<mutex> lk(mtx);
         if (nums>0) 
            nums--;
         cout<<"nums: "<<nums<<endl;
        cv.notify_one();
    }
}


int main ()
{
    std::thread t[5];

    for (int i=0; i<5; ++i) {
        std::this_thread::sleep_for(100ms);
        t[i] = std::thread(run,i);
    }
    unique_lock<mutex> lk(latch);
    //waiting for 3 thread finish
    cout<<"main: "<<nums<<endl;
    cv.wait(lk,[=]{return (nums>0)?true:false;});
    cout<<"finish 3 thread"<<endl;
    
    for (int i=0; i<5; ++i) {
        t[i].join();
    }

    
    return 0;
}
