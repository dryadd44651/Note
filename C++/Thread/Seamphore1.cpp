#include <iostream>           // std::cout
#include <thread>             // std::thread
#include <mutex>              // std::mutex
#include <condition_variable> // std::condition_variable_any

std::mutex mtx,sem;
int nums = 2;
std::condition_variable  cv;


void run (int i) {
    {unique_lock<mutex> lk(mtx);//critical section
        cv.wait(lk,[=]{return (nums!=0)?true:false;});
        //while (nums==0) cv.wait(lk);
        nums--;
    }
    cout <<nums<<endl;
        for (int j=0; j<5; ++j) {
            std::this_thread::sleep_for(50ms);
            cout <<"T:"<<i<<endl;
        }
    {unique_lock<mutex> lk(mtx);
        nums++;
        cv.notify_one();
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
