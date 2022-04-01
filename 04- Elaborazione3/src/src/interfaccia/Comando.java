package interfaccia;
import dominio.Othello;

public interface Comando {

    public String getCodiceComando();


    public String getDescrizioneComando();


    public void esegui(Othello othello);
}
