package interfaccia;

import dominio.Othello;
import dominio.Pacchetto;

public class ComandoRegistraPacchetto implements Comando{

    public static final String codiceComando="2";
    public static final String descrizioneComando="registra pacchetto";

    public String getCodiceComando() {
        return codiceComando;
    }

    public String getDescrizioneComando() {
        return descrizioneComando;
    }

    public void esegui(Othello othello) {
        try{
        for(Pacchetto p : othello.visualizzaPacchetto()) {
            System.out.println(p.toString());
        }
        System.out.println("   Inserisci il codice del pacchetto: ");
        String codice_pacchetto = Parser.getInstance().read();
        System.out.println();
        boolean codice_corretto = false;
        for(Pacchetto p : othello.visualizzaPacchetto()) {
            if(p.getCodice().equals(codice_pacchetto))
                codice_corretto = true;
        }
        if(codice_corretto) {
            othello.registraPacchetto(codice_pacchetto);
            System.out.println("Il pacchetto è stato registrato");
        } else
            System.out.println("Codice pacchetto non valido");
    } catch (Exception E){
            System.out.println("ATTENZIONE! Devi prima effettuare la registrazione della stanza");
        }
    }
}
