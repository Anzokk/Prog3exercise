import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class Client {


    public void connection(int port){

        ArrayList<Studente> lista=new ArrayList<>();
        for(int i=0; i<10; i++){
            lista.add(new Studente("stud"+i, "descrizione"));
        }

        try{
            Socket  socket =new Socket("localhost", port);
            ObjectOutputStream out=new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(lista);

            socket.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }


    public static void main(String[] args){

       Client c=new Client();
        c.connection(7003);

    }
}