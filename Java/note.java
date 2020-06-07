public class UsesEx{ 
    
	public static void main(String[] args) { 
		//String
        String a = "1234";
        a+='5';
        for(Object i : a.toCharArray())
            System.out.print(i);
        System.out.println();
        
        //array
        //int arr[] = new int[10]; 
        int arr[] = {5,6,7,1,9,8,2,3,4};
        for(Object i : arr)
            System.out.print(i);
        System.out.println();
        System.out.println(Arrays.binarySearch(arr, 3));
        Arrays.sort(arr);
        String tmp = Arrays.toString(Arrays.copyOfRange(arr,0,9));
        System.out.println(tmp);
        String[] strList = tmp.split(",");
        for(Object i : strList)
            System.out.print(i);
        System.out.println();

        String str = "word1, word2 word3@word4?word5.word6"; 
        String[] arrOfStr = str.split("[, ?.@]"); 
        for (String i : arrOfStr) 
            System.out.print(i);
        System.out.println();
        
        //list
        //List<Integer> arrlist = new ArrayList<Integer>(Arrays.asList(arr)); 
        //arr = arrlist.toArray(arr);
        ArrayList<Integer> arrlist = new ArrayList<Integer>(); 
        for (int i=1; i<=9; i++) 
            arrlist.add(i);
        arrlist.remove(3); 
        arrlist.set(3, 30);
        for (int i=0; i<arrlist.size(); i++) 
            System.out.print(arrlist.get(i)+" ");
        System.out.println();
        //List<String> arrlist2 = arrlist.subList(2, 4); 
        class cmp implements Comparator<Integer>{ 
            public int compare(Integer a, Integer b){return b-a;} 
        }
        
        
        Collections.sort(arrlist,new cmp());
        for (int i=0; i<arrlist.size(); i++) 
            System.out.print(arrlist.get(i)+" ");
        System.out.println();
        //search
        System.out.println(Collections.binarySearch(arrlist, 30));
        //stack        
        Stack<Integer> stack = new Stack<Integer>(); 
        // Use add() method to add elements into the Stack 
        stack.add(10); 
        stack.add(15); 
        System.out.println(stack.get(0));
        System.out.println(stack.get(1));
        stack.pop();
        System.out.println(stack.get(0));
        
        
        //Queue
        Queue<Integer> q = new LinkedList<>(); 
  
        for (int i=0; i<5; i++) 
            q.add(i); 
        System.out.println(q.peek());
        q.remove();
        System.out.println(q.peek());
        
        //heap
        //max heap
        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>(Collections.reverseOrder());
        //min heap
        //PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>();
        pQueue.add(10); 
        pQueue.add(30); 
        pQueue.add(400); 
        pQueue.add(20); 
        System.out.println(pQueue.peek()); 
        pQueue.remove(30); 
        pQueue.remove(400); 
        System.out.println(pQueue.peek());
        //self defined
        class pqCmp implements Comparator<String> { 
            public int compare(String str1, String str2) 
            { 
                String first_Str; 
                String second_Str; 
                first_Str = str1; 
                second_Str = str2; 
                return second_Str.compareTo(first_Str); 
            } 
        }
        PriorityQueue<String> queue = new PriorityQueue<String>(new pqCmp());
        queue.add("G"); 
        queue.add("E"); 
        queue.add("E"); 
        System.out.println(queue.peek());
        
        //Map
        Map< String,Integer> hm = new HashMap< String,Integer>(); 
        hm.put("a", new Integer(100)); 
        hm.put("b", new Integer(200)); 
        hm.put("c", new Integer(300)); 
        hm.put("d", new Integer(400)); 
        System.out.println(hm.get("a"));
        for (Map.Entry< String,Integer> entry : hm.entrySet())
            System.out.println(entry);
         // Returns Set view      
//         Set< Map.Entry< String,Integer> > st = hm.entrySet();    

//         for (Map.Entry< String,Integer> me:st) 
//         { 
//            System.out.print(me.getKey()+":"); 
//            System.out.println(me.getValue()); 
//         } 
        Set<String> hash_Set = new HashSet<String>(); 
        hash_Set.add("Geeks"); 
        hash_Set.add("For"); 
        hash_Set.add("Geeks"); 
        hash_Set.add("Example"); 
        hash_Set.add("Set"); 
        hash_Set.add("Set"); 
        System.out.println(hash_Set); 

        Set<Integer> set = new HashSet<Integer>(); 
        set.addAll(Arrays.asList(new Integer[] {1, 3, 2, 4, 8, 9, 0})); 
        for(Object i : set )
            System.out.print(i);
        System.out.println();
	} 

} 







