public class Observ1 {

    public static void main(String[] args) {

        Visualizer v = new Visualizer();
        Filter f = new Filter();
        Counter c = new Counter();
        f.addObserver(v);
        c.addObserver(f);
        c.start();
    }
}