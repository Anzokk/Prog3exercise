package Main;

public class SortableArray <T extends Comparable>{
    private SortableList<T> obj;
    public void addModule(SortableList<T> e){
        this.obj=e;
    }

    public void add(T e){
        this.obj.add(e);
    }

    public void remove(T e){
        this.obj.remove(e);
    }

    public void sort(){
        this.obj.sort();
    }

    public void print(){
        this.obj.print();
    }
}
