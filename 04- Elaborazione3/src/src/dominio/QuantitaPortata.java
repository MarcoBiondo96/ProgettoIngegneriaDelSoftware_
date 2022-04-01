package dominio;

public class QuantitaPortata extends Portata {
    private int quantita;

    public QuantitaPortata(Portata p, int quantita) {
        super(p.getNome(), p.isDisponibilita(), p.getPrezzo());
        this.quantita = quantita;
    }
    public QuantitaPortata(Portata p){
        super(p.getNome(), p.isDisponibilita(), p.getPrezzo());
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
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
}
