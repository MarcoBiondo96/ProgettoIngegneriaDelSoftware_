package interfaccia;

import dominio.Prenotazione;

import java.io.Serializable;

public class StatoCheckout implements Stato, Serializable {
    @Override
    public void gestioneStatoPrenotazione(Prenotazione prenotazione, String stato){
        if(stato.equals("Concluso"))
            prenotazione.setStatoprenotazione(new StatoConcluso());
    }
    @Override
    public boolean equalsStato(String stato){
        if(stato.equalsIgnoreCase("Check-out"))
            return true;
        else
            return false;
    }
}
