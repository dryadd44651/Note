import java.util.concurrent.*; 
import java.util.*;

class joinEx extends Thread{
    int num,times;
    
    joinEx(int num,int times){
        this.num = num;
        this.times = times;
    }
    @Override
    public void run(){
        try{
            for(int i =0;i<times;i++){
                    System.out.println("("+this.num+" : "+i+")");   
                    Thread.sleep(1);
			    }
        }catch(Exception e){
            System.err.print("error");   
        }

    }
    
}


public class Test { 
    
	public static void main(String[] args) throws InterruptedException 
	{ 
        joinEx p1 = new joinEx(1,10);
        joinEx p2 = new joinEx(2,5);
        
        p1.start();
        p2.start();
        p2.join();
        //p2 has join the main, so main will wait until p2 finish.
        System.out.println("end of main");
	} 
}
// (1 : 0)
// (2 : 0)
// (1 : 1)
// (2 : 1)
// (1 : 2)
// (2 : 2)
// (1 : 3)
// (2 : 3)
// (1 : 4)
// (2 : 4)
// (1 : 5)
// end of main
// (1 : 6)
// (1 : 7)
// (1 : 8)
// (1 : 9)
