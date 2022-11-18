import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ActivityCounter c = new ActivityCounter();
        ArrayList<Thread> executionOrder=new ArrayList<>();
        ArrayList<Thread> firstWait=new ArrayList<>();

        Thread a0 = new Thread(new Azioni(0, 3, new ArrayList<>(), c));

        executionOrder.add(a0);
        firstWait.add(a0);

        Thread a1 = new Thread(new Azioni(1, 15, firstWait, c));
        Thread a2 = new Thread(new Azioni(2, 5, firstWait, c));
        Thread a3 = new Thread(new Azioni(3, 10, firstWait, c));

        executionOrder.add(a1);
        executionOrder.add(a2);
        executionOrder.add(a3);

        ArrayList<Thread> secondWait=new ArrayList<>();
        secondWait.add(a1);
        secondWait.add(a2);
        secondWait.add(a3);

        Thread a4 = new Thread(new Azioni(4, 4, secondWait, c));

        executionOrder.add(a4);

        Thread ciccio = a4;

        for(int i=0; i<5; i++){
            ArrayList<Thread> attesa= new ArrayList<>();
            attesa.add(ciccio);
            Thread a5 = new Thread(new Azioni(5, 5, attesa, c));
            ciccio=a5;
            executionOrder.add(a5);
        }


        for(Thread thread:executionOrder){
            thread.start();
        }
    }
}