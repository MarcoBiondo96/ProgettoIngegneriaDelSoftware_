package dominio;

import java.io.Serializable;

public class Portata implements Serializable {
    protected String nome;
    protected boolean disponibilita;
    protected float prezzo;

    public Portata(String nome, float prezzo) {
        this.nome = nome;
        this.disponibilita = true;
        this.prezzo = prezzo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isDisponibilita() {
        return disponibilita;
    }

    public void setDisponibilita(boolean disponibilita) {
        this.disponibilita = disponibilita;
    }

    public float getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }

    public String toString(){
        if(disponibilita)
            return "Nome :"+this.nome+" Prezzo: "+this.prezzo + " è disponibile";
        else
            return "Nome :"+this.nome+" Prezzo: "+this.prezzo + " non è disponibile";
    }
}
