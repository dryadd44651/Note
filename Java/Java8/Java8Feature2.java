import java.util.*; 
import java.util.stream.*; 

class Demo 
{ 
    public static void main(String args[]) 
    { 

        //input
        List<Integer> number = Arrays.asList(6,7,1,2,0,2,3,4,5); 
        List<String> names = Arrays.asList("Steven","Seven","Collection","Stream"); 


        // map filter sort
        // map
        // use pre defined functional interface
        Function<Integer,Integer> mapper = (x) -> x*x;
        //number = number.stream().map(x -> x*x).collect(Collectors.toList()); 
        number = number.stream().map(mapper).collect(Collectors.toList()); 
        System.out.println(number);
        // filter
        names = names.stream().filter(s->s.startsWith("S")).collect(Collectors.toList()); 
        System.out.println(names);

        number = number.stream().filter(n->n>2).collect(Collectors.toList()); 
        System.out.println(number);

        // sort
        names = names.stream().sorted().collect(Collectors.toList()); 
        System.out.println(names);
        number = number.stream().sorted().collect(Collectors.toList()); 
        System.out.println(number);

        //foreach
        Consumer<Integer> cm=i->System.out.print(i+"-");
        //number.stream().map(x->x*x).forEach(y->System.out.print(y+"-"));
        number.stream().map(x->x*x).forEach(cm); 
        System.out.println();
        // reduce
        // Optional: the class may or may not contain a non-null value( get() to get data)
        // Optional/Optional<Integer>/Object/var
        // Optional ans = number.stream().reduce((x,y)->x+y); 
        // if reduce don't give initial value, it will return Optional
        // Integer/int
        // Integer ans = number.stream().reduce((x,y)->x+y).get(); 
        // System.out.println(ans);
        
        BiFunction<Integer,Integer,Integer> reducer = (x,y)->x+y;
        // int ans = number.stream().reduce((x,y)->x+y).get(); 
        // reduce(0,...) initial as 0 => int
        // int ans = number.stream().reduce(0,(x,y)->x+y); 
        int ans = number.stream().reduce(0,reducer::apply); 
        System.out.println(ans);
        
        // how to use reduce
        // https://www.geeksforgeeks.org/stream-reduce-java-examples/
        // long reduce(int identity, LongBinaryOperator op);
        // identity = default or initial value.
        // BinaryOperator = functional interface, take two values and produces a new value.
    } 
} 
