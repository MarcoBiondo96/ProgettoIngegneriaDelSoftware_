package interfaccia;

import dominio.Prenotazione;

import java.io.Serializable;

public interface Stato  {
    public void gestioneStatoPrenotazione(Prenotazione prenotazione, String stato);
    public boolean equalsStato(String stato);
}
