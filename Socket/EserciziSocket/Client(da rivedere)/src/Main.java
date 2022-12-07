import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {

        ArrayList<Studente> lista=new ArrayList<>();
        for(int i=0; i<10; i++){
            lista.add(new Studente("stud"+i, "descrizione"));
        }

        Socket socket = new Socket("127.0.0.1", 7003);
        ObjectOutputStream out=new ObjectOutputStream(socket.getOutputStream());

    }
}