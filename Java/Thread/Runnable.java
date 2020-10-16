
public class Main {
    //how to pass a function
	public static void main(String[] args) throws InterruptedException {
		Runnable command = () -> {System.out.println("run");};
        new Thread(command).start();
	}
}
// void Foo(String str) {
//     class OneShotTask implements Runnable {
//         String str;
//         OneShotTask(String s) { str = s; }
//         public void run() {
//             someFunc(str);
//         }
//     }
//     Thread t = new Thread(new OneShotTask(str));
//     t.start();
// }
