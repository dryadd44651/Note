// "static void main" must be defined in a public class.
import java.util.concurrent.Callable; 
import java.util.concurrent.FutureTask; 

class RunnableClass implements Runnable {
    public void run() {
        for(int i=0; i < 5; i++) { 
            try {
              Thread.sleep(1);
            }
            catch(Exception e) {
              //  Block of code to handle errors
            }
            
            System.out.println("Runnable: "+i);
        }
    }
}
class ThreadClass extends Thread {
    public void run() {
        for(int i=0; i < 5; i++) {
            try {
              Thread.sleep(1);
            }
            catch(Exception e) {
              //  Block of code to handle errors
            }
            System.out.println("Thread: "+i);
        }
    }
}
class CallableClass implements Callable {
    public Integer call() throws Exception  {
        int i = 0;
        for(i=0; i < 5; i++) {
            Thread.sleep(1);
            System.out.println("Callable: "+i);
        }
        return i;
    }
}
public class Main {
    public static void main(String[] args)throws Exception {
        ThreadClass tc = new ThreadClass();
        
        RunnableClass rc = new RunnableClass();
        Thread rt = new Thread(rc);
        
        CallableClass cc = new CallableClass();
        // Future<Integer> future = executorService.submit(task);
        // Integer result = future.get().intValue();
        FutureTask ft = new FutureTask(cc);
        Thread ct = new Thread(ft);
        
        //the main thread will stop until callable thread get return value
        Integer result = cc.call();
        System.out.println("result: "+result);
        
        tc.start();
        rt.start();
        //main thread won't stop
        //ct.start();
        
        // tc.join();
        // rt.join();
        // tc.join();
    }
}


// Callable: 0
// Callable: 1
// Callable: 2
// Callable: 3
// Callable: 4
// result: 5
// Thread: 0
// Runnable: 0
// Thread: 1
// Runnable: 1
// Thread: 2
// Runnable: 2
// Thread: 3
// Runnable: 3
// Thread: 4
// Runnable: 4
