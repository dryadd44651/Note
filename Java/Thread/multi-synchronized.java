// A Java program to demonstrate working of 
// synchronized. 
import java.io.*; 
import java.util.*; 
  
// A Class used to send a message 
class Sender 
{ 
    public void send(String msg) 
    { 
        System.out.println("Sending\t"  + msg ); 
        try
        { 
            Thread.sleep(1000); 
        } 
        catch (Exception e) 
        { 
            System.out.println("Thread  interrupted."); 
        } 
        System.out.println("\n" + msg + "Sent"); 
    } 
} 
  
// Class for send a message using Threads 
class ThreadedSend extends Thread 
{ 
    private String msg; 
    Sender  sender; 
  
    // Recieves a message object and a string 
    // message to be sent 
    ThreadedSend(String m,  Sender obj) 
    { 
        msg = m; 
        sender = obj; 
    } 
  
    public void run() 
    { 
        // Only one thread can send a message 
        // at a time. 
        synchronized(sender) 
        { 
            // synchronizing the snd object 
            sender.send(msg); 
        } 
    } 
} 
  
// Driver class 
class SyncDemo 
{ 
    public static void main(String args[]) 
    { 
        Sender snd1 = new Sender(); 
        Sender snd2 = new Sender(); 
        ThreadedSend S1 = new ThreadedSend( " s1 Hi " , snd1 ); 
        ThreadedSend S2 = new ThreadedSend( " s2 Bye " , snd1 ); 
        ThreadedSend S3 = new ThreadedSend( " s3 Hi " , snd2 ); 
        ThreadedSend S4 = new ThreadedSend( " s4 Bye " , snd2 );
        // Start two threads of ThreadedSend type 
        S1.start(); 
        S2.start(); 
        S3.start(); 
        S4.start(); 
        // wait for threads to end 
        try
        { 
            S1.join(); 
            S2.join(); 
            S3.join(); 
            S4.join();
        } 
        catch(Exception e) 
        { 
            System.out.println("Interrupted"); 
        } 
    } 
} 
//s1 and s2 will share same critical section, s3 and s4 share same one.
// Sending	 s1 Hi 
// Sending	 s3 Hi 

//  s3 Hi Sent

//  s1 Hi Sent
// Sending	 s2 Bye 
// Sending	 s4 Bye 

//  s2 Bye Sent

//  s4 Bye Sent
