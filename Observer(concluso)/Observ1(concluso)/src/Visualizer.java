import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Visualizer implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        try{
            List<Integer> list=(List<Integer>) arg;
            for (Integer i : list) {
                System.out.println(i.intValue());
            }
            System.out.println();
        }catch(ClassCastException err){
            System.out.println("errore di casting");
        }

    }
}

