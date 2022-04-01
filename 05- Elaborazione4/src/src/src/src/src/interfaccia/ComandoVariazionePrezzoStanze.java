package interfaccia;

import dominio.Othello;
import dominio.Stanza;

import java.io.FileNotFoundException;
import java.sql.Date;

public class ComandoVariazionePrezzoStanze implements Comando{
    public static final String codiceComando="3";
    public static final String descrizioneComando="variazione prezzo stanze";

    public String getCodiceComando() {
        return codiceComando;
    }

    public String getDescrizioneComando() {
        return descrizioneComando;
    }

    public void esegui(Othello othello) {
        try{
            for(Stanza s : othello.getStanze()) {
                System.out.println(s.toString());
            }
            System.out.println("   Inserisci data inizio periodo variazione(YYYY-MM-dd): ");
            String dataI = Parser.getInstance().read();
            System.out.println("   Inserisci data fine periodo variazione(YYYY-MM-dd): ");
            String dataF = Parser.getInstance().read();
            System.out.println("   Inserisci la variazione: ");
            String var = Parser.getInstance().read();
            othello.aggiungiPeriodoVariazione(Date.valueOf(dataI), Date.valueOf(dataF), Float.valueOf(var));
            try {
                othello.storePeriodiVariazione();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }catch(Exception E){
            System.out.println("");
        }
    }
}
