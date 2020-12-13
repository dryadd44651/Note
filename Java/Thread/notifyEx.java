class notifyEx extends Thread{
    Object lock;
    int num;
    notifyEx(Object lock,int num){
        this.lock = lock;
        this.num = num;
    }
    @Override
    public void run(){
        try{
            synchronized(lock) {lock.wait();}
            for(int i =0;i<10;i++){
                System.out.print(this.num);    
                Thread.sleep(1);
            }
            synchronized(lock) {lock.notify();}
        }catch(Exception e){
            System.err.print("error");   
        }
    }
    
}


public class Test { 
    
	public static void main(String[] args) throws InterruptedException 
	{ 
        Object lock = new Object();
        notifyEx p1 = new notifyEx(lock,1);
        notifyEx p2 = new notifyEx(lock,2);
        notifyEx p3 = new notifyEx(lock,3);
        p1.start();
        p2.start();
        p3.start();
        try{Thread.sleep(10);}catch(Exception e){}
        //notify: only one thread will be revoked
        synchronized(lock) {lock.notify();}
        //111111111133333333332222222222
        //notifyAll: all threads will be revoked
        //synchronized(lock) {lock.notifyAll();}
        //123123123123123123123213213213
	} 
}
