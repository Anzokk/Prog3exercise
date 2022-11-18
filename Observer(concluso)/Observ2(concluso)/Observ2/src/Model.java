import java.util.ArrayList;
import java.util.Observable;
import java.util.Random;

public class Model extends Observable {
    ArrayList<String> prov;
    Random rand=new Random();

    public Model(){
        prov= new ArrayList<>();
        int cont;
        for (cont =0; cont <10; cont++){
            prov.add("proverbio" + cont);
        }
    }

    public String estrai(){
        return prov.get(rand.nextInt(prov.size()));
    }

    public void updat(){
        setChanged();
        notifyObservers(this.estrai());
    }
}
