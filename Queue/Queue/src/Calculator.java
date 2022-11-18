import java.util.List;

public class Calculator {
    public abstract class numerini<T extends Comparable<T>> implements Comparable<numerini<T>>{
        T number;

        public abstract numerini<T> add(numerini<T> num);

        public numerini(T number){
            this.number=number;
        }

        public int compareTo(numerini<T> n){
            return this.compareTo(n);
        }


    }

    public static <T extends Comparable<T>> void print(List<? extends numerini<T>> list){
        for (numerini<T> i:list){
            System.out.println(i);
        }
    }

    public static <T extends Comparable<T>> numerini<T> sum(List<? extends numerini<T>> list){
        numerini<T> n = list.get(0);
        for(int i=1; i<list.size(); i++){
            n.add(list.get(i));
        }
        return n;
    }

    public static <T extends Comparable<T>> numerini<T> max(List<? extends numerini<T>> list){
        numerini<T> max = list.get(0);
        for (numerini<T> i:list){
            if(i.compareTo(max)>0){
                max=i;
            }
        }return max;
    }
}