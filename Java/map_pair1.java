
public class Main {
    public static void main(String[] args) {
        var pair = new Pair<Integer, String>(Integer.valueOf(1), "GeeksforGeeks"); 
        //System.out.println(pair); 

        var hm = new HashMap< Pair<Integer, String>,String>(); 

        hm.put(pair,"a"); 
        System.out.println(hm.get(pair));
        System.out.println(hm.get(new Pair<Integer, String>(Integer.valueOf(1), "GeeksforGeeks")));
        //both key can work!
        for (var entry : hm.entrySet())
            System.out.println(entry);

    }
}
