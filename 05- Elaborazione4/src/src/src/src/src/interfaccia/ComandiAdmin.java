package interfaccia;

import dominio.Othello;

public class ComandiAdmin implements Comando{

    public static final String codiceComando = "5";
    public static final String descrizioneComando = "comandi admin";

    public String getCodiceComando() {
        return codiceComando;
    }

    public String getDescrizioneComando() {
        return descrizioneComando;
    }

    public void esegui(Othello othello) {
        ComandiAdminConsole ca= new ComandiAdminConsole();
        ca.start(othello);
    }
}
