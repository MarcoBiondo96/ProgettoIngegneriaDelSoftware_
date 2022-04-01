package interfaccia;

import dominio.Othello;

import java.sql.Date;
import java.time.LocalDate;
import dominio.Stanza;

public class ComandoCreaNuovoServizioInCamera implements Comando{

    public static final String codiceComando = "1";
    public static final String descrizioneComando = "associa camera";

    public String getCodiceComando() {
        return codiceComando;
    }

    public String getDescrizioneComando() {
        return descrizioneComando;
    }

    public void esegui(Othello othello) {
        System.out.println("   Inserisci il codice della stanza da cui effettuare il servizio in camera: ");
        String cod_stanza = Parser.getInstance().read();
        System.out.println();
        boolean esiste= false;
        for(Stanza s: othello.getStanze()){
            if(cod_stanza.equals(s.getCodice())){
                LocalDate d= LocalDate.now();
                othello.creaServizioInCamera(cod_stanza, Date.valueOf(d.toString()));
                esiste=true;
                break;
            }
        }
        if(esiste)
            System.out.println("E' stato creato un nuovo servizio in camera ");
        else
            System.out.println("La stanza scelta non esiste");
    }
}

