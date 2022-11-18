import java.util.ArrayList;
import java.util.List;

public class Main <T extends Comparable<T>>{
    public static void main(String[] args) {
        ArrayList<Integer> a=new ArrayList<>();
        Queue<Integer> q=new Queue(a);

        ArrayList<T> d=new ArrayList<>();
        Queue<Double> h=new Queue(d);

        System.out.println("");
        for(int i=0; i<5; i++){
            q.enqueue(i);
        }

        System.out.println("");
        for(int i=0; i<5; i++){
            h.enqueue((double) i/(double)10);
        }

        //q.deQueue();
        //h.deQueue();
        System.out.println("Somma di q: "+Calculator.sum(d));

        q.output();
        h.output();
    }
}