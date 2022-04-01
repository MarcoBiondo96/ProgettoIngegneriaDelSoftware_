package interfaccia;

import dominio.Othello;

public class ComandoAnnullaPrenotazioneInCorso implements Comando{

    public static final String codiceComando="5";
    public static final String descrizioneComando="annulla prenotazione in corso";

    public String getCodiceComando() {
        return codiceComando;
    }

    public String getDescrizioneComando() {
        return descrizioneComando;
    }

    public void esegui(Othello othello) {
        othello.annullaPrenotazioneInCorso();
       System.out.println("Annullamento prenotazione in corso effettuato");
    }
}
