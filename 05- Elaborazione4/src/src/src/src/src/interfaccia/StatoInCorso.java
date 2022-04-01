package interfaccia;

import dominio.Prenotazione;

import java.io.Serializable;

public class StatoInCorso implements  Stato, Serializable {
    @Override
    public void gestioneStatoPrenotazione(Prenotazione prenotazione, String stato){
        if(stato.equals("Creato"))
            prenotazione.setStatoprenotazione(new StatoCreato());
    }
    @Override
    public boolean equalsStato(String stato){
        if(stato.equalsIgnoreCase("In_corso"))
            return true;
        else
            return false;
    }
}
