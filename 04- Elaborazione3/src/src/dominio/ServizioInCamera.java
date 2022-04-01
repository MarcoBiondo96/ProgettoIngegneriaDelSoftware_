package dominio;

import java.util.Date;
import java.util.List;

public class ServizioInCamera {
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

    /*public void creaOrdineInCorso(){
        this.ordineInCorso = new Ordine();
    }*/

    /*public void resettaOrdineInCorso(){
        this.ordineInCorso =null;
    }

    public void registraOrdine(){
        this.ordini.add(this.ordineInCorso);
        this.resettaOrdineInCorso();
    }

    public List<Ordine> getOrdini(){
        return this.ordini;
    }*/
}
