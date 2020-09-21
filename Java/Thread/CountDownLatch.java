import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CountDownLatchDemo {
	public static void main(String args[]) throws InterruptedException, ExecutionException {
		ExecutorService executor = Executors.newFixedThreadPool(4);
		// Let us create task that is going to
		// wait for four threads before it starts
		CountDownLatch latch = new CountDownLatch(4);

		// Let us create four worker
		// threads and start them.
		Future<String> first = executor.submit(new Worker(4000, latch, "WORKER-1"));
		Future<String> second = executor.submit(new Worker(3000, latch, "WORKER-2"));
		Future<String> third = executor.submit(new Worker(2000, latch, "WORKER-3"));
		Future<String> fourth = executor.submit(new Worker(1000, latch, "WORKER-4"));

		// The main task waits for four threads (CountDownLatch(4))
		latch.await();
        
		// Main thread has started
		System.out.println(first.get());
		System.out.println(second.get());
		System.out.println(third.get());
		System.out.println(fourth.get());
		executor.shutdown();
	}
}

// A class to represent threads for which
// the main thread waits.
class Worker implements Callable<String> {
	private int delay;
	private CountDownLatch latch;
	private String name;

	public Worker(int delay, CountDownLatch latch, String name) {
		this.delay = delay;
		this.latch = latch;
		this.name = name;
	}

	@Override
	public String call() {
		try {
			Thread.sleep(delay);
			latch.countDown();
			System.out.println(Thread.currentThread().getName() + " finished");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return this.name + ":" + Thread.currentThread().getName();
	}
}
// pool-1-thread-4 finished
// pool-1-thread-3 finished
// pool-1-thread-2 finished
// pool-1-thread-1 finished
// WORKER-1:pool-1-thread-1
// WORKER-2:pool-1-thread-2
// WORKER-3:pool-1-thread-3
// WORKER-4:pool-1-thread-4

// await() and get() will have same function(wait until finish)
// latch.await();
        
// System.out.println(first.get());
// System.out.println(second.get());
// System.out.println(third.get());
// System.out.println(fourth.get());
