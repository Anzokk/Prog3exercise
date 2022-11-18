package com.example.client;
import java.util.ArrayList;
import java.util.List;

public class Model {
    Email q = new Email(1, "Text " + 1, "Argomento" + 1);
    Email w = new Email(2, "Text " + 2, "Argomento" + 2);
    Email e = new Email(3, "Text " + 3, "Argomento" + 3);
    Email r = new Email(4, "Text " + 4, "Argomento" + 4);
    Email t = new Email(5, "Text " + 5, "Argomento" + 5);
    Email y = new Email(6, "Text " + 6, "Argomento" + 6);
    Email u = new Email(7, "Text " + 7, "Argomento" + 7);
    Email i = new Email(8, "Text " + 8, "Argomento" + 8);
    Email o = new Email(9, "Text " + 9, "Argomento" + 9);

    private final List<Email> store;

    public Model(){
        store = new ArrayList<>();
        store.add(q);
        store.add(w);
        store.add(e);
        store.add(r);
        store.add(t);
        store.add(y);
        store.add(u);
        store.add(i);
        store.add(o);
    }

    public void rimuovi (int n) {
        for (int i = 0; i < store.size(); i++) {
            if (store.get(i).getId() == n) {
                store.remove(store.get(i));
            }
        }
    }

    public String ritorna() {
        String output="Messaggio n" + 1 + " " + store.get(0).getArgomento() + " " + store.get(0).getText()+"\n";
        for(int i=1; i<store.size(); i++){
            output+="Messaggio n" + store.get(i).getId() + " " + store.get(i).getArgomento() + " " + store.get(i).getText()+"\n";
        }
        return output;
    }

    public String ritorna(int n){
        return "Messaggio n" + store.get(n-1).getId() + " " + store.get(n-1).getArgomento() + " " + store.get(n-1).getText()+"\n";
    }
}

