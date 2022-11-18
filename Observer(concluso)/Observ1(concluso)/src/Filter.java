import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Filter extends Observable implements Observer{

    private final List<Integer> list= new ArrayList<>();

    public void update(Observable o, Object arg) {
        list.add((int)arg);
        if (list.size()%2==0) {
            System.out.println("lista size: " + list.size());
            setChanged();
            notifyObservers(list);
        }
    }
}