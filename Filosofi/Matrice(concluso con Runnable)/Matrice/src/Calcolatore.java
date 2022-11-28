public class Calcolatore implements Runnable{

    int[][] matrice;
    int i, somma=0;

    public Calcolatore(int i, int[][] matric){
        this.matrice=matric;
        this.i=i;
        new Thread(this).start();
    }

    @Override
    public void run() {
        for(int m=0; m<matrice.length; m++){
            somma+=matrice[i][m];
        }
        System.out.println("Riga:"+i+" Somma="+somma);
    }
}
