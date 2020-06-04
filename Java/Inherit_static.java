// "static void main" must be defined in a public class.

class obja{
    static int i = 0;
    int j = 0;
    void setI(int val){i = val;}
    int getI(){return i;}
    void setJ(int val){j = val;}
    int getJ(){return j;}
    
}
class objb extends obja{}
class objc extends obja{}
public class Main {

    public static void main(String[] args) {
        
        obja a = new obja();
        objb b = new objb();
        objc c = new objc();
        //a.setI(5);
        b.setI(3);
        b.setJ(3);
        System.out.println(a.getI());
        System.out.println(b.getI());
        System.out.println(c.getI());
        System.out.println(a.getJ());
        System.out.println(b.getJ());
        System.out.println(c.getJ());
        //onley static will share same variable
        // 3
        // 3
        // 3
        // 0
        // 3
        // 0
    }
}
