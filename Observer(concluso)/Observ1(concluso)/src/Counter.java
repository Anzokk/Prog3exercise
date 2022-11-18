import java.util.Observable;

public class Counter extends Observable {
    private int c;
    public void start() {
        for (c =0; c <50; c++) {
            if (c %5==0) {
                setChanged();
                notifyObservers(c);
            }
        }
    }
}