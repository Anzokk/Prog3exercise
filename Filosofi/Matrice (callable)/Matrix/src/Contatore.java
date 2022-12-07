import java.util.concurrent.Callable;

public class Contatore implements Callable <Integer> {

    private final int id;
    private final int[][] matrice;
    int somma=0;

    public Contatore(int id, int[][] matrice){
        this.id=id;
        this.matrice=matrice;
    }

    @Override
    public Integer call(){
        for(int n=0; n< matrice.length; n++){
            somma += matrice[id][n];
        }
        return somma;
    }
}
