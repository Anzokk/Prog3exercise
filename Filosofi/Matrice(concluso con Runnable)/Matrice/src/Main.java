import java.util.Random;

public class Main {
    public static void main(String[] args) {

        int length=5;
        int min=1;
        Random rand = new Random();
        int[][] matrice= new int[length][length];

        for(int i=0; i<matrice.length; i++){
            for (int n=0; n<matrice[i].length; n++){
                matrice[i][n]=rand.nextInt(length - min) + min;
            }
        }
        for (int m=0; m<length; m++){
            new Thread(new Calcolatore(m, matrice));
        }
    }
}