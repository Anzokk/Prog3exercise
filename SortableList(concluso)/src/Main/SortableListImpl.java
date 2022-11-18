package Main;
import java.util.ArrayList;
import java.util.Collections;

public class SortableListImpl <T extends Comparable> implements SortableList{

    private ArrayList<T> a;

    public SortableListImpl(){
        a = new ArrayList<T>();
    }

    public void add(Comparable e) {
        a.add((T) e);
    }

    public void remove(Comparable e) {
        a.remove(e);
    }

    public void print(){
        for (T el:a){
            System.out.println(el);
        }
    }

    public void sort(){
        Collections.sort(a);
    }
}
