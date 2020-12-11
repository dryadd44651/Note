class BlockingQueue<E> {
    
    private List<E> queue = new LinkedList<E>();
    private int limit = 10;
    
    public BlockingQueue(int limit){
        this.limit = limit;
    }
    //put and take share same synchronized
    //when queue reach limit: put->wait, release key
    //take() will notifyAll when queue reach limit (this.queue.size() == this.limit)
    //take() will finish the function first then, release the key
    //notifyAll: one of waiting thread will be restart
    public synchronized void put(E item) throws InterruptedException {
        while (this.queue.size() == this.limit) {
            System.out.println(" Waiting for Enqueue ");
            wait();
        }
        if (this.queue.isEmpty()) {
            //release the key after leaving the function
            //key for waiting take()
            notifyAll();
        }
        System.out.println(" Enqueue " + item.toString());
        this.queue.add(item);
    }
    
    public synchronized E take() throws InterruptedException {
        while (this.queue.isEmpty()) {
            System.out.println(" Waiting for Dequeue ");
            wait();
        }
        if (this.queue.size() == this.limit) {
            //release the key after leaving the function
            //key for waiting put()
            notifyAll();
        }
        E val = this.queue.remove(0);
        System.out.println(" Dequeue " + val.toString());
        return val;
    }

}
class procuder extends Thread 
{ 
    BlockingQueue<Integer> bq;
    int id;
    procuder(BlockingQueue<Integer> src,int id){
        bq = src;
        this.id = id;
    }
    public void run() 
    { 
        try {
            bq.put(id);
          
        } catch (Exception e) {
          System.out.println("Something went wrong.");
        }
        
    } 
} 
class consumer extends Thread 
{ 
    BlockingQueue<Integer> bq;
    consumer(BlockingQueue<Integer> src){
        bq = src;
    }
    public void run() 
    { 
        try {
          bq.take();
        } catch (Exception e) {
          System.out.println("Something went wrong.");
        }
        
    } 
} 
class MyMainClass {
    public static void main(String[] args) {
        BlockingQueue<Integer> bq = new BlockingQueue(2);
        procuder p1 = new procuder(bq,1);
        procuder p2 = new procuder(bq,2);
        procuder p3 = new procuder(bq,3);
        procuder p4 = new procuder(bq,4);
        consumer c1 = new consumer(bq);
        consumer c2 = new consumer(bq);
        consumer c3 = new consumer(bq);
        consumer c4 = new consumer(bq);
        c1.start();
        try{Thread.sleep(10);}catch(Exception e) { } 
        p1.start();
        p2.start();
        p3.start();
        p4.start();
        try{Thread.sleep(10);}catch(Exception e) { } 
        c2.start();
        c3.start();
        c4.start();
    }
}
