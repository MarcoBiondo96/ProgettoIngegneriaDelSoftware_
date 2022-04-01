package dominio;

public class Pacchetto {

    private String codice;
    private String nome;
    private float prezzo;

    public Pacchetto(String c, String n, float p){
        this.codice = c;
        this.nome = n;
        this.prezzo = p;
    }

    public String getCodice(){ return this.codice; }

    public String getNome(){ return this.nome; }

    public float getPrezzo(){ return this.prezzo; }

    public String toString(){
        return "codice: " + this.codice + ", nome: " + this.nome + ", prezzo: " + this.prezzo + "\n";
    }
}
