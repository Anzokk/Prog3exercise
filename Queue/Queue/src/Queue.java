import java.util.List;

public class Queue<T> {
    private List<T> m;
    public Queue(List<T> l){
        this.m=l;
    }

    public void output(){
        System.out.println(m);
    }

    public boolean empty(){
        return m.isEmpty();
    }

    public void deQueue(){
        if(!m.isEmpty()){
            m.remove(0);
        }
    }

    public void enqueue(T n){
        m.add(n);
    }
}
