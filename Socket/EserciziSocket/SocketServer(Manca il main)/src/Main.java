import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class Main {

        Socket s = null;
        ObjectInputStream inStream = null;
        ObjectOutputStream outStream = null;

        public void listen(int port){
            try {
                ServerSocket socket = new ServerSocket(port);

                //condizione per uscire dal while infinito in serve client
                while (true) {
                    serveClient(socket);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (s != null) {
                    try {
                        s.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        public void serveClient(ServerSocket socket){
            try{

                openComunication(socket);

                //approfodire bene l'utilizzo degli streaming channel
                List<Studente> lista=(List<Studente>) inStream.readObject();
                updateList(lista);

                //scrive su outStream la lista degli elementi modificati flush forza a scrivere subito
                outStream.writeObject(lista);
                outStream.flush();

            }catch(ClassNotFoundException | IOException e){
                e.printStackTrace();
            }finally{
                closeStream();
            }

        }

        public void openComunication(ServerSocket socket){
            try{
                s=socket.accept();
                inStream=new ObjectInputStream(s.getInputStream());
                outStream=new ObjectOutputStream(s.getOutputStream());
                outStream.flush();
                System.out.println("Connessione riuscita");
            }catch (IOException e){
                e.printStackTrace();
            }
        }

        public void updateList(List<Studente> studenti){
            if(studenti!=null && studenti.size()>0){
                for(Studente s:studenti){
                    s.setDescrizione(s.getDescrizione()+"modificato");
                }
            }
        }

        public void closeStream(){
            try{
                if(inStream!=null){
                    inStream.close();
                }
                if(outStream!=null){
                    outStream.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }

    public static void main(String[] args) {

    }
}