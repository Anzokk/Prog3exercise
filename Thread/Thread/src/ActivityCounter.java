public class ActivityCounter {
    private int contatore=0;

    public ActivityCounter(){
        int contatorer=0;
    }

    public synchronized void add(){
        contatore++;
    }

    public int getContatore(){
        return contatore;
    }
}
