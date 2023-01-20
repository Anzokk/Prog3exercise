import java.util.Random;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;


public class Main {
    private static final int NUM_THREAD=5;

    public static void main(String[] args) {

        final int length=5;
        final int min=1;
        Random rand=new Random();
        int[][] matrice=new int[length][length];

        for(int i=0; i< matrice.length; i++){
            for(int n=0; n<matrice[i].length; n++){
                matrice[i][n]=rand.nextInt(length - min)+min;
            }
        }

        Vector<FutureTask<Integer>> tasks = new Vector<>();
        ExecutorService exec= Executors.newFixedThreadPool(NUM_THREAD);
        for(int m=0; m<length; m++){
            FutureTask<Integer> lavoro=new FutureTask<>(new Contatore(m, matrice));
            tasks.add(lavoro);
            exec.execute(lavoro);
        }
    }
}