
public class Main {
    public static void main(String[] args) {
        // create anonymous thread
        new Thread(new Runnable() 
        { 
            @Override
            public void run() 
            { 
                System.out.println("New thread created"); 
            } 
        }).start(); 
        
        new Thread(()-> {System.out.println("New thread created");}).start(); 
                         
        
    }
}
