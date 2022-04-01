package interfaccia;

import dominio.Othello;

public class ComandoNuovoServizio implements Comando{

    public static final String codiceComando="4";
    public static final String descrizioneComando="nuovo servizio";

    public String getCodiceComando() {
        return codiceComando;
    }

    public String getDescrizioneComando() {
        return descrizioneComando;
    }

    public void esegui(Othello othello) {
        NuovoServizioConsole ns= new NuovoServizioConsole();
        ns.start(othello);
    }

}
