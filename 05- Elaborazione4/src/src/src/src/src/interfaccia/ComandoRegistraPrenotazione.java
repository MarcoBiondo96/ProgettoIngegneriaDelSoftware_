package interfaccia;

import dominio.Othello;
import dominio.Prenotazione;

import java.io.FileNotFoundException;
import java.sql.Date;

public class ComandoRegistraPrenotazione implements Comando{

    public static final String codiceComando="4";
    public static final String descrizioneComando="registra prenotazione";

    public String getCodiceComando() {
        return codiceComando;
    }

    public String getDescrizioneComando() {
        return descrizioneComando;
    }

    public void esegui(Othello othello) {
        try {
                othello.registraPrenotazione();
                System.out.println("Il cliente: " + othello.getPrenotazioneInCorso().getCliente().toString() + " ha effettuato la prenotazione!");
                othello.annullaPrenotazioneInCorso();
                try {
                    othello.storePrenotazioni();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
        } catch (Exception E){
            System.out.println("ATTENZIONE! Dati inseriti non validi!");
            othello.annullaPrenotazioneInCorso();
        }
    }
}
