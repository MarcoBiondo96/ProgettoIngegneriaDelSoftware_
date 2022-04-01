package interfaccia;

import dominio.Othello;

import java.util.*;


public class ComandoNuovaPrenotazione implements Comando{

    public static final String codiceComando="1";
    public static final String descrizioneComando="nuova prenotazione";

    public String getCodiceComando() {
        return codiceComando;
    }

    public String getDescrizioneComando() {
        return descrizioneComando;
    }

    public void esegui(Othello othello) {
        NuovaPrenotazioneConsole npc= new NuovaPrenotazioneConsole();
        npc.start(othello);
    }
}
