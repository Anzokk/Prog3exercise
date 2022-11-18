import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class Controller implements ActionListener, Observer {

    Model model;
    View view;

    public Controller(Model model, View view){
        this.model = model;
        this.view = view;
        view.setListenerForNextProverbButtonPress(this);
        model.addObserver(this);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        model.updat();
    }

    @Override
    public void update(Observable o, Object arg) {
        view.setText((String) arg);
    }
}
