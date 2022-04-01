package dominio;

public class Stanza {

    private String codice;
    private String tipologia;
    private float prezzo;

    public Stanza(String c, String t, float p){
        this.codice = c;
        this.tipologia = t;
        this.prezzo = p;
    }

    public String getCodice(){ return this.codice; }

    public String getTipologia(){ return this.tipologia; }

    public float getPrezzo(){ return this.prezzo; }

    public String toString(){
        return "codice: " + this.codice + ", tipologia: " + this.tipologia + ", prezzo: " + this.prezzo + "\n";
    }

}
