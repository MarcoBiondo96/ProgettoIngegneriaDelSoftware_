package interfaccia;

import dominio.Othello;

public class ComandoEsci implements Comando{

    public static final String codiceComando="0";
    public static final String descrizioneComando="esci";

    public String getCodiceComando() {
        return codiceComando;
    }

    public String getDescrizioneComando() {
        return descrizioneComando;
    }

    public void esegui(Othello othello) {
        //torna al menu precedente oppure esce se non ci sono menu precedenti
    }
}
