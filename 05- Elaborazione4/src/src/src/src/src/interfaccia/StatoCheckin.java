package interfaccia;

import dominio.Prenotazione;

import java.io.Serializable;

public class StatoCheckin implements Stato, Serializable {
    @Override
    public void gestioneStatoPrenotazione(Prenotazione prenotazione, String stato){
        if(stato.equals("Check-out"))
            prenotazione.setStatoprenotazione(new StatoCheckout());
    }

    @Override
    public boolean equalsStato(String stato){
        if(stato.equalsIgnoreCase("Check-in"))
            return true;
        else
            return false;
    }
}
