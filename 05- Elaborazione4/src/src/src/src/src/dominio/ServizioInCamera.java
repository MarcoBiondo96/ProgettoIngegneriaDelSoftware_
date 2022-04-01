package dominio;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class ServizioInCamera implements Serializable {
    private String Codice;
    private Date data;
    private Stanza stanza;
    //private List<Ordine> ordini;
    private Ordine ordineInCorso;

    public ServizioInCamera(Date data, Stanza stanza) {
        this.data = data;
        this.stanza = stanza;
        this.ordineInCorso = new Ordine();
    }

    public void registraPortata(Portata p,int quantita){
        ordineInCorso.setQuantitaPortata(p,quantita);
    }

    public Ordine getOrdineInCorso() {
        return ordineInCorso;
    }

    public Stanza getStanza(){ return  stanza;}

    public Date getData() {
        return data;
    }


}
