package interfaccia;

import dominio.Othello;

public class ComandoModificaPrenotazione implements Comando{

    public static final String codiceComando="2";
    public static final String descrizioneComando="modifica/cancella prenotazione";

    public String getCodiceComando() {
        return codiceComando;
    }

    public String getDescrizioneComando() {
        return descrizioneComando;
    }

    public void esegui(Othello othello) {
        ModificaPrenotazioneConsole mpc= new ModificaPrenotazioneConsole();
        mpc.start(othello);
    }
}
