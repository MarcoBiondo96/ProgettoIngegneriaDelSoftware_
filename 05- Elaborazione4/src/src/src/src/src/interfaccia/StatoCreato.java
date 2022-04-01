package interfaccia;

import dominio.Prenotazione;

import java.io.Serializable;

public class StatoCreato implements Stato, Serializable {
    @Override
    public void gestioneStatoPrenotazione(Prenotazione prenotazione, String stato){
        if(stato.equals("Check-in"))
            prenotazione.setStatoprenotazione(new StatoCheckin());
    }
    @Override
    public boolean equalsStato(String stato){
        if(stato.equalsIgnoreCase("Creato"))
            return true;
        else
            return false;
    }
}
