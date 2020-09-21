// java program to demonstrate 
// use of semaphores Locks 
import java.util.concurrent.*; 

//A shared resource/class. 
class Shared 
{ 
	static int count = 0; 
} 

class MyThread extends Thread 
{ 
	Semaphore sem; 
	String threadName; 
	public MyThread(Semaphore sem, String threadName) 
	{ 
		super(threadName); 
		this.sem = sem; 
		this.threadName = threadName; 
	} 

	@Override
	public void run() { 

			System.out.println("Starting " + threadName); 
			try
			{ 
				// First, get a permit. 
				System.out.println(threadName + " is waiting for a permit."); 
			
				// acquiring the lock 
				sem.acquire(); 
			
				System.out.println(threadName + " gets a permit."); 
		
				// Now, accessing the shared resource. 
				// other waiting threads will wait, until this 
				// thread release the lock 
				for(int i=0; i < 5; i++) 
				{ 
					Shared.count++; 
					System.out.println(threadName + ": " + Shared.count); 
		
					// Now, allowing a context switch -- if possible. 
					// for thread B to execute 
					Thread.sleep(10); 
				} 
			} catch (InterruptedException exc) { 
					System.out.println(exc); 
				} 
		
				// Release the permit. 
				System.out.println(threadName + " releases the permit."); 
				sem.release(); 
		} 
 
} 

// Driver class 
public class SemaphoreDemo 
{ 
	public static void main(String args[]) throws InterruptedException 
	{ 
		// creating a Semaphore object 
		// with number of permits 1 
		Semaphore sem = new Semaphore(2); 
		
		// creating two threads with name A and B 
		// Note that thread A will increment the count 
		// and thread B will decrement the count 
		MyThread mt1 = new MyThread(sem, "A"); 
		MyThread mt2 = new MyThread(sem, "B"); 
		
		// stating threads A and B 
		mt1.start(); 
		mt2.start(); 
		
		// waiting for threads A and B 
		mt1.join(); 
		mt2.join(); 
		
		// count will always remain 0 after 
		// both threads will complete their execution 
		System.out.println("count: " + Shared.count); 
	} 
}
// with one semaphore thread B will wait thread A
// Semaphore sem = new Semaphore(1); 
// output:

// Starting A
// A is waiting for a permit.
// A gets a permit.
// Starting B
// B is waiting for a permit.
// A: 1
// A: 2
// A: 3
// A: 4
// A: 5
// A releases the permit.
// B gets a permit.
// B: 6
// B: 7
// B: 8
// B: 9
// B: 10
// B releases the permit.
// count: 10

//==========================================

// with two semaphore thread B will not wait thread A
// Semaphore sem = new Semaphore(2); 
// output:


// Starting B
// B is waiting for a permit.
// B gets a permit.
// Starting A
// A is waiting for a permit.
// A gets a permit.
// B: 2
// A: 1
// B: 3
// A: 4
// B: 5
// A: 6
// B: 7
// A: 8
// B: 9
// A: 10
// B releases the permit.
// A releases the permit.
// count: 10



