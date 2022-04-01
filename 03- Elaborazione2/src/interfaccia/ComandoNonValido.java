package interfaccia;

import dominio.Othello;

public class ComandoNonValido implements Comando{

    public static final String codiceComando="-1";
    public static final String descrizioneComando="comando non valido";

    public String getCodiceComando() {
        return codiceComando;
    }

    public String getDescrizioneComando() {
        return descrizioneComando;
    }

    public void esegui(Othello othello) {
        System.out.println("   COMANDO INESISTENTE");
    }
}
