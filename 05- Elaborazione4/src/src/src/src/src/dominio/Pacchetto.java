package dominio;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Pacchetto implements Serializable {

    private String codice;
    private String nome;
    private float prezzo;
    private List<Servizio> servizi;

    public Pacchetto(String c, String n, float p){
        this.codice = c;
        this.nome = n;
        this.prezzo = p;
        this.servizi = new LinkedList<Servizio>();
    }

    public String getCodice(){ return this.codice; }

    public String getNome(){ return this.nome; }

    public float getPrezzo(){ return this.prezzo; }

    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }

    public List<Servizio> getServizi() {
        return this.servizi;
    }

    public String toString(){
        return "codice: " + this.codice + ", nome: " + this.nome + ", prezzo: " + this.prezzo + "\n";
    }
}
