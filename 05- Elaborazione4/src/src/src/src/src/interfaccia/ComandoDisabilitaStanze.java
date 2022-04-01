package interfaccia;

import dominio.Othello;
import dominio.Stanza;

import java.io.FileNotFoundException;
import java.sql.Date;

public class ComandoDisabilitaStanze implements Comando{

    public static final String codiceComando="1";
    public static final String descrizioneComando="disabilita stanze";

    public String getCodiceComando() {
        return codiceComando;
    }

    public String getDescrizioneComando() {
        return descrizioneComando;
    }

    public void esegui(Othello othello) {
        try {
            System.out.println("   Inserisci data inizio manutenzione (YYYY-MM-dd): ");
            String dataI = Parser.getInstance().read();
            System.out.println("   Inserisci data fine manutenzione (YYYY-MM-dd): ");
            String dataF = Parser.getInstance().read();
            for(Stanza s: othello.mostraStanzeNonPrenotate(Date.valueOf(dataI), Date.valueOf(dataF))){
                System.out.println(s.toString());
            }
            boolean codice_corretto = false;
            System.out.println("   Inserisci il codice della stanza da disabilitare: ");
            String codice_stanza = Parser.getInstance().read();
            for (Stanza s : othello.mostraStanzeNonPrenotate(Date.valueOf(dataI), Date.valueOf(dataF))) {
                if (s.getCodice().equals(codice_stanza))
                    codice_corretto = true;
            }
            System.out.println();
            if (codice_corretto) {
                othello.modificaStanza(codice_stanza, false);
                try {
                    othello.storeStanze();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                System.out.println("La stanza: " + codice_stanza + " è stata disabilitata.");
            } else
                System.out.println("Il codice della stanza inserito non è valido");
        }catch(Exception E){
            System.out.println("ATTENZIONE! Dati inseriti non validi");
        }
    }

}
