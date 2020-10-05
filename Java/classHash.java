

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arrlist = new ArrayList<Integer>(); 
        var hm = new HashMap< ArrayList<Integer>,Integer>(); 
        for (int i=1; i<=9; i++) {
            arrlist.add(i);
            hm.put((ArrayList)arrlist.clone(),Integer.valueOf(i));
        }
        
        
        
        for (var entry : hm.entrySet())
            System.out.println(entry);
        ArrayList<Integer> a = new ArrayList<Integer>(
            List.of(1, 2, 3));
        //get num (hm store the (ArrayList)arrlist.clone() address hash value)
        System.out.println(hm.get(hm.get(a)));
        
        
    }
}

