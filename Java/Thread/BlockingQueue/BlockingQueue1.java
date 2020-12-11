// Java Program to demonstrate usuage of BlockingQueue 

import java.util.concurrent.*; 
import java.util.*; 

public class BlockingQueue1 { 

	public static void main(String[] args) throws InterruptedException 
	{ 
		int capacity = 5; 
		BlockingQueue queue = new ArrayBlockingQueue(capacity); 
        for(int i =0;i<4;i++){
            queue.put(i);//when the queue is full, it will block

        }
        new Thread(()-> {
            try {

                for(int i =0;i<10;i++){
                queue.put(i);
            }
                queue.put(-1);
            }
            catch(Exception e) {
                System.err.println("error");
            }
        }).start(); 
        new Thread(()-> {
            try {
                while(true){
                int i = (int)queue.poll();
                if(i==-1)
                    break;
                else
                    System.out.println(i);
                }
            }
            catch(Exception e) {
                System.err.println("error");
            }
        }).start(); 

		System.out.println("queue contains " + queue); 
	} 
}
