import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class View extends JFrame{
    private JLabel label1;
    private JButton bottone;

    public View(String s) {
        super(s);
        setSize(400, 400);
        setLayout(new FlowLayout(FlowLayout.LEFT, 20, 40));

        bottone = new JButton("Oooo rand");
        bottone.setSize(80, 40);
        this.add(bottone);

        label1 = new JLabel("piselo");
        this.add(label1);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void setListenerForNextProverbButtonPress(ActionListener c) {
        bottone.addActionListener(c);
    }
    public void setText(String r){
        label1.setText(r);
    }
}
