# Comparable
```
public class Main {
    //inner class must be static (main is static)
    static class Npair implements Comparable<Npair>{
        public int f,s;
        public Npair(int f,int s){
            this.f = f;
            this.s = s;
        }

        public int compareTo(Npair o) {
            return this.f - o.f;
        }
    }
    public static void main(String[] args) {
        List<Npair> arr = new ArrayList<Npair>();
        for(var i=10;i>-1;i--)
            arr.add(new Npair(i,i));
        Collections.sort(arr);
        for(var a:arr)
            System.out.println(a.f);
        
    }
}
```
# Comparator
```
public class Main {
    static class Npair{
        public int f,s;
        public Npair(int f,int s){
            this.f = f;
            this.s = s;
        }
    }
    static class cmp implements Comparator<Npair>{ 
            public int compare(Npair a, Npair b){return b.f-a.f;} 
    }
    public static void main(String[] args) {
        List<Npair> arr = new ArrayList<Npair>();
        for(var i=10;i>-1;i--)
            arr.add(new Npair(i,i));
        Collections.sort(arr,new cmp());
        for(var a:arr)
            System.out.println(a.f);
        
    }
}
```

# Comparator with Pair
```
public class Main {
    public static void main(String[] args) {
        class cmp implements Comparator<Pair<Integer,Integer>>{ 
            public int compare(Pair<Integer,Integer> a, Pair<Integer,Integer> b){return b.getKey()-a.getKey();} 
        }
        var arr = new ArrayList<Pair<Integer,Integer>>();
        for(var i=10;i>-1;i--)
            arr.add(new Pair<Integer,Integer>(i,i));
        Collections.sort(arr,new cmp());
        for(var a:arr)
            System.out.println(a.getKey());
        
    }
}
```
### Comparable Pair is too complicate
https://gist.github.com/cstroe/7b8ee18a21254c1bf983
