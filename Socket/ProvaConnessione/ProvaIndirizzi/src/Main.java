import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

public class Main {
    public static void main(String[] args) {
        String host = "www.unito.it";
        try {
            InetAddress local = InetAddress.getLocalHost();
            InetAddress addr = InetAddress.getByName(host);
            System.out.println ("Locale: indirizzo IP: " + local);
            System.out.println("Remoto: indirizzo IP: " + addr);

            URL Oracle = new URL("https://docs.oracle.com/en/java/");


        } catch(UnknownHostException | MalformedURLException e)
            {System.out.println(host +"sconosciuto");}
    }
}