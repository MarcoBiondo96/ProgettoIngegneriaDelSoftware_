package interfaccia;

import dominio.Othello;
import dominio.Stanza;

import java.sql.Date;

public class ComandoRegistraStanze implements Comando {

    public static final String codiceComando = "1";
    public static final String descrizioneComando = "registra stanze";

    public String getCodiceComando() {
        return codiceComando;
    }

    public String getDescrizioneComando() {
        return descrizioneComando;
    }

    public void esegui(Othello othello) {

        try {
            System.out.println("   Inserisci la tipologia di stanza (singola, matrimoniale, suite): ");
            String tipologia_stanza = Parser.getInstance().read();
            if (!(tipologia_stanza.equalsIgnoreCase("singola") || tipologia_stanza.equalsIgnoreCase("matrimoniale") || tipologia_stanza.equalsIgnoreCase("suite")))
                throw new Exception();
            System.out.println("   Inserisci data inizio (YYYY-MM-dd): ");
            String dataI = Parser.getInstance().read();
            System.out.println("   Inserisci data fine (YYYY-MM-dd): ");
            String dataF = Parser.getInstance().read();
            System.out.println();
            for (Stanza s : othello.visualizzaStanze(tipologia_stanza, Date.valueOf(dataI), Date.valueOf(dataF))) {
                System.out.println(s.toString());
            }
            if (othello.visualizzaStanze(tipologia_stanza, Date.valueOf(dataI), Date.valueOf(dataF)).isEmpty()) {
                System.out.println("Non ci sono stanze disponibili per quella tipologia e data");
            } else {
                boolean codice_corretto = false;
                System.out.println("   Inserisci il codice della stanza: ");
                String codice_stanza = Parser.getInstance().read();
                for (Stanza s : othello.visualizzaStanze(tipologia_stanza, Date.valueOf(dataI), Date.valueOf(dataF))) {
                    if (s.getCodice().equals(codice_stanza))
                        codice_corretto = true;
                }
                System.out.println();
                if (codice_corretto) {
                    othello.registraStanze(codice_stanza);//inserire date in prenotazioneincorso
                    othello.getPrenotazioneInCorso().setData_inizio(Date.valueOf(dataI));
                    othello.getPrenotazioneInCorso().setData_fine(Date.valueOf(dataF));
                    System.out.println("La stanza è stata registrata");
                } else
                    System.out.println("Il codice della stanza inserito non è valido");
              }
            } catch(Exception E){
                System.out.println("ATTENZIONE! Dati inseriti non validi!");
        }
    }
}