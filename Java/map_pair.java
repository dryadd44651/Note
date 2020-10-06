

public class Main {
    public static void main(String[] args) {
        var pair = new Pair<Integer, String>(Integer.valueOf(1), "GeeksforGeeks"); 
        System.out.println(pair); 

        var hm = new HashMap< String,Pair<Integer, String>>(); 

        hm.put("a", pair); 
        hm.put("b", new Pair<Integer, String>(Integer.valueOf(2), "GeeksforGeeks")); 
        hm.put("c", new Pair<Integer, String>(Integer.valueOf(3), "GeeksforGeeks")); 
        hm.put("d", new Pair<Integer, String>(Integer.valueOf(4), "GeeksforGeeks")); 
        System.out.println(hm.get("a"));
        for (var entry : hm.entrySet())
            System.out.println(entry);

    }
}



// For 1 element   - Unit<A>
// For 2 elements  - Pair<A, B> 
// For 3 elements  - Triplet<A, B, C> 
// For 4 elements  - Quartet<A, B, C, D> 
// For 5 elements  - Quintet<A, B, C, D, E>
// For 6 elements  - Sextet<A, B, C, D, E, F> 
// For 7 elements  - Septet<A, B, C, D, E, F, G>
// For 8 elements  - Octet<A, B, C, D, E, F, G, H>
// For 9 elements  - Ennead<A, B, C, D, E, F, G, H, I>
// For 10 elements - Decade<A, B, C, D, E, F, G, H, I, J>
