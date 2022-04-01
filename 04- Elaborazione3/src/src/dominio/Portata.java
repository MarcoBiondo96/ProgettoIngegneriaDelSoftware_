package dominio;

public class Portata {
    protected String nome;
    protected boolean disponibilita;
    protected float prezzo;

    public Portata(String nome, boolean disponibilita, float prezzo) {
        this.nome = nome;
        this.disponibilita = disponibilita;
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
        return "Nome :"+this.nome+" Prezzo: "+this.prezzo;
    }
}
