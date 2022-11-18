package Main;
interface SortableList <T extends Comparable>{
    public void add(T e);
    public void remove(T e);
    public void print();
    public void sort();
}
