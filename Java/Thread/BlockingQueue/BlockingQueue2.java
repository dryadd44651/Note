package com.antra.BlockingQueue;

import java.util.concurrent.*; 
import java.util.*; 


class Procuder extends Thread { 
    BlockingQueue bq;
    Procuder(BlockingQueue src){
        bq = src;
    }
    public void run(){ 
        try {
        	for(int i =0;i<10;i++){
        		bq.put(i);
            }
        	bq.put(-1);
          
        } catch (Exception e) {
          System.out.println("Something went wrong.");
        }
    }
} 
class Consumer extends Thread { 
    BlockingQueue bq;
    Consumer(BlockingQueue src){
        bq = src;
    }
    public void run() { 
        try {
        	while(true){
                Integer i = (Integer)bq.take();
                if(i==-1)
                    break;
                else
                    System.out.println(i);
                }
        } catch (Exception e) {
          System.out.println("Something went wrong.");
        }
        
    } 
} 

public class BlockingQueue2 { 

	public static void main(String[] args) 
	{ 
		int capacity = 5; 
		BlockingQueue bq = new ArrayBlockingQueue(capacity); 
		
		Procuder procuder = new Procuder(bq);
		Consumer consumer = new Consumer(bq);
		procuder.start();
		consumer.start();
		//System.out.println("queue contains " + bq); 
	} 
}
