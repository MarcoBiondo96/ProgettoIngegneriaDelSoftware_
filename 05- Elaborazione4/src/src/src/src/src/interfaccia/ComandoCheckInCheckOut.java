package interfaccia;

import dominio.Othello;

public class ComandoCheckInCheckOut implements Comando{

    public static final String codiceComando="6";
    public static final String descrizioneComando="check-in/check-out";

    public String getCodiceComando() {
        return codiceComando;
    }

    public String getDescrizioneComando() {
        return descrizioneComando;
    }

    public void esegui(Othello othello) {
        CheckinCheckOutConsole cico= new CheckinCheckOutConsole();
        cico.start(othello);
    }
}
