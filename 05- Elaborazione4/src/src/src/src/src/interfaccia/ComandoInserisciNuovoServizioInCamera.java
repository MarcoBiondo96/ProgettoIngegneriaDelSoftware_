package interfaccia;

import dominio.Othello;

public class ComandoInserisciNuovoServizioInCamera implements Comando{

    public static final String codiceComando="3";
    public static final String descrizioneComando="inserisci nuovo servizio in camera";

    public String getCodiceComando() {
        return codiceComando;
    }

    public String getDescrizioneComando() {
        return descrizioneComando;
    }

    public void esegui(Othello othello) {
        InserisciNuovoServizioInCameraConsole nsc= new InserisciNuovoServizioInCameraConsole();
        nsc.start(othello);
    }
}