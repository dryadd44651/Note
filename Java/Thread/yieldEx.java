class yieldEx extends Thread{
    
    int num;
    yieldEx(int num){
        this.num = num;
    }
    @Override
    public void run(){
        try{
            for(int i =0;i<40;i++){
                System.out.println("("+this.num+" : "+i+")");   
			    if (i % 10 == 0) {
			        //force to yield the CPU time
                    Thread.yield();
			    }
            }    
        }catch(Exception e){
            System.err.print("error");   
        }

    }
    
}


public class Test { 
    
	public static void main(String[] args) throws InterruptedException 
	{ 
        yieldEx p1 = new yieldEx(1);
        yieldEx p2 = new yieldEx(2);
        // time slot will be very short
        // p1.setPriority(Thread.MIN_PRIORITY);
        // p2.setPriority(Thread.MIN_PRIORITY);
        //time slot will be very long
        p1.setPriority(Thread.MAX_PRIORITY);
        p2.setPriority(Thread.MAX_PRIORITY);
        p1.start();
        p2.start();
        
	} 
}
// Thread must change when mod 10 = 0
// (2 : 9)
// (2 : 10)
// (1 : 1)
// (1 : 2)
// .
// .
// .
// (1 : 18)
// (1 : 19)
// (1 : 20)
// (2 : 21)
// (2 : 22)
// .
// .
// .
// (1 : 28)
// (1 : 29)
// (1 : 30)
// (2 : 31)
// (2 : 32)
