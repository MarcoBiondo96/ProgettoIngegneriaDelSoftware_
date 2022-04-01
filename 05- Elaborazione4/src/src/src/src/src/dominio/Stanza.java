package dominio;

import java.io.Serializable;

public class Stanza implements Serializable {

    private String codice;
    private String tipologia;
    private float prezzo;
    private boolean disponibile;

    public Stanza(String c, String t, float p, boolean d){
        this.codice = c;
        this.tipologia = t;
        this.prezzo = p;
        this.disponibile = d;
    }

    public String getCodice(){ return this.codice; }

    public String getTipologia(){ return this.tipologia; }

    public float getPrezzo(){ return this.prezzo; }

    public boolean getDisponibile(){ return this.disponibile; }

    public void setDisponibile(Boolean d){ this.disponibile = d; }

    public String toString(){
        return "codice: " + this.codice + ", tipologia: " + this.tipologia + ", prezzo: " + this.prezzo + "\n";
    }

}
