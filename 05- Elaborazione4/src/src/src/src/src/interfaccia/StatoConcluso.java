package interfaccia;

import dominio.Prenotazione;

import java.io.Serializable;

public class StatoConcluso implements Stato, Serializable {
    @Override
    public void gestioneStatoPrenotazione(Prenotazione prenotazione, String stato){}
    @Override
    public boolean equalsStato(String stato){
        if(stato.equalsIgnoreCase("Concluso"))
            return true;
        else
            return false;
    }
}
