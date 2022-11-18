package Main;

public class Main {
    public static void main(String[] args) {
        SortableArray<Integer> coso=new SortableArray<Integer>();
        coso.addModule(new SortableListImpl<>());

        coso.add(4);
        coso.add(2);
        coso.add(6);
        coso.add(9);
        coso.add(1);
        coso.add(5);

        coso.print();
        coso.sort();
        System.out.println("dopo sort: ");
        coso.print();
    }
}