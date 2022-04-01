package interfaccia;

import dominio.Othello;
import dominio.Stanza;

import java.io.FileNotFoundException;
import java.sql.Date;

public class ComandoRiabilitaStanze implements Comando{

    public static final String codiceComando="2";
    public static final String descrizioneComando="riabilita stanze";

    public String getCodiceComando() {
        return codiceComando;
    }

    public String getDescrizioneComando() {
        return descrizioneComando;
    }

    public void esegui(Othello othello) {
        try {
            for(Stanza s: othello.mostraStanzeDisabilitate()){
                System.out.println(s.toString());
            }
            boolean codice_corretto = false;
            System.out.println("   Inserisci il codice della stanza da riabilitare: ");
            String codice_stanza = Parser.getInstance().read();
            for (Stanza s : othello.mostraStanzeDisabilitate()) {
                if (s.getCodice().equals(codice_stanza))
                    codice_corretto = true;
            }
            System.out.println();
            if (codice_corretto) {
                othello.modificaStanza(codice_stanza, true);
                try {
                    othello.storeStanze();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                System.out.println("La stanza: " + codice_stanza + " è stata riabilitata.");
            } else
                System.out.println("Il codice della stanza inserito non è valido");
        }catch(Exception E){
            System.out.println("ATTENZIONE! Dati inseriti non validi");
        }
    }
}
