import java.util.concurrent.Semaphore;

public class Filosofi implements Runnable{

    private Semaphore sem = new Semaphore(5);

    private int leftArm=0;
    private int rightArm=0;
    private int posate=5;
    private int p;

    public Filosofi(int p){
        this.p=p;
        new Thread(this).start();
    }
    public void prendiPosataSinistra(){
        posate--;
        leftArm++;
    }

    public void prendiPosataDestra(){
        posate--;
        rightArm++;
    }
    public void rilasciaPosataSinistra(){
        posate++;
        leftArm--;
    }

    public void rilasciaPosataDestra(){
        posate++;
        rightArm--;
    }
    @Override
    public void run() {
        for(int i=0; i<5; i++){ //ciclo pensare e mangiare 5 volte

            try {
                System.out.println("Sto pensando... " + p);
                Thread.sleep(3*1000L); //azione pensare
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Acquisisco posate "+p);
            try {
                sem.acquire();
                prendiPosataSinistra();
                sem.acquire();
                prendiPosataDestra();
                System.out.println("sto per mangiare "+p);
                Thread.sleep(3*1000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }finally{
                rilasciaPosataSinistra();
                sem.release();
                rilasciaPosataDestra();
                sem.release();
                System.out.println("torno a pensare "+p);
            }


        }
    }
}
