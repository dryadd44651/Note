// condition_variable example
#include <iostream>           // std::cout
#include <thread>             // std::thread
#include <mutex>              // std::mutex, std::unique_lock
#include <condition_variable> // std::condition_variable
#include <chrono>

std::mutex mtx;
std::condition_variable cv;
bool ready = false;

void print_id (int id) {
  std::unique_lock<std::mutex> lck(mtx);
  while (!ready) cv.wait(lck);
  for (int i=0; i<3; ++i){
      std::this_thread::sleep_for(1ms);
      std::cout << "thread " << id << '\n';
  }
    
}

void go() {
    std::this_thread::sleep_for(10ms);
    std::unique_lock<std::mutex> lck(mtx);
    cout<<"go!!"<<endl;
    ready = true;
    cv.notify_all();
}

int main ()
{
  std::thread threads[3];
  // spawn 3 threads:
  for (int i=0; i<3; ++i)
    threads[i] = std::thread(print_id,i);

  std::cout <<endl<< "3 threads ready to race...\n";
  go();                       // go!

  for (auto& th : threads) th.join();

  return 0;
}

//without mutex
//std::unique_lock<std::mutex> lck(mtx);
//while (!ready) cv.wait(lck);

// 3 threads ready to race...
// thread 0
// thread 1
// thread 2
// thread 0
// thread 1
// thread 2
// thread 0
// thread 1
// thread 2
// go!!

//with mutex
// 3 threads ready to race...
// go!!
// thread 0
// thread 0
// thread 0
// thread 1
// thread 1
// thread 1
// thread 2
// thread 2
// thread 2

