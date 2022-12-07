public class Studente {

    private String nome;
    private String descrizione;

    public Studente(String nome, String descrizione){
        this.nome=nome;
        this.descrizione=descrizione;
    }

    public String getNome() {
        return nome;
    }

    public String getDescrizione() {
        return descrizione;
    }
}
