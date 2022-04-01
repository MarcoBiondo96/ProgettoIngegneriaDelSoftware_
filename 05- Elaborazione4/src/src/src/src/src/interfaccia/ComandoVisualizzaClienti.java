package interfaccia;

import dominio.Othello;
import dominio.Cliente;
import dominio.Prenotazione;

public class ComandoVisualizzaClienti implements Comando{

    public static final String codiceComando="7";
    public static final String descrizioneComando="visualizza clienti";

    public String getCodiceComando() {
        return codiceComando;
    }

    public String getDescrizioneComando() {
        return descrizioneComando;
    }

    public void esegui(Othello othello) {

        boolean trovato=false;
        for (Prenotazione p : othello.visualizzaPrenotazioni()) {
            if (p.getStatoprenotazione().equalsStato("Check-in")) {
                System.out.println(p.getCliente().toString());
                trovato=true;
            }
        }
        if(!trovato)
            System.out.println("Non è presente alcun check-in");
    }
}
