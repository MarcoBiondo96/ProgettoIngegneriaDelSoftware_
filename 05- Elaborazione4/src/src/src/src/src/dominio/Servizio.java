package dominio;

import java.io.Serializable;

public class Servizio implements Serializable {

    private String tipo;
    private float prezzo;

    public Servizio(String tipo, float prezzo) {
        this.tipo = tipo;
        this.prezzo = prezzo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public float getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }

    public String toString(){
        return "tipo: " + this.tipo + " prezzo: " + this.prezzo;
    }
}
