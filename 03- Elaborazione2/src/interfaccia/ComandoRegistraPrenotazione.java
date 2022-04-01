package interfaccia;

import dominio.Othello;
import dominio.Prenotazione;

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
            System.out.println("   Inserisci nuovamente data inizio (YYYY-MM-dd): ");
            String dataI = Parser.getInstance().read();
            System.out.println("   Inserisci nuovamente data fine (YYYY-MM-dd): ");
            String dataF = Parser.getInstance().read();
            System.out.println();
            if (othello.verificaStanzaPrenotata(othello.getPrenotazioneInCorso().getStanza().getCodice(), Date.valueOf(dataI), Date.valueOf(dataF))) {
                othello.registraPrenotazione(Date.valueOf(dataI), Date.valueOf(dataF));
                System.out.println("Il cliente: " + othello.getPrenotazioneInCorso().getCliente().toString() + " ha effettuato la prenotazione!");
                othello.annullaPrenotazioneInCorso();
                for(Prenotazione p : othello.visualizzaPrenotazioni()){
                    System.out.println(p.toString());
                }
            } else
                System.out.println("Attenzione, le date inserite non sono disponibili!");
        } catch (Exception E){
            System.out.println("ATTENZIONE! Dati inseriti non validi!");
        }
    }
}
