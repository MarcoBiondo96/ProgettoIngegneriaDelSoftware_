package interfaccia;

import dominio.Othello;
import dominio.Prenotazione;

import java.util.Iterator;

public class ComandoCalcolaConto implements Comando{

    public static final String codiceComando="8";
    public static final String descrizioneComando="calcola conto cliente";

    public String getCodiceComando() {
        return codiceComando;
    }

    public String getDescrizioneComando() {
        return descrizioneComando;
    }

    public void esegui(Othello othello) {
        System.out.println("   Inserisci il codice fiscale del cliente: ");
        String codice_cliente = Parser.getInstance().read();
        System.out.println();
        boolean cliente_presente = false;
        for (Prenotazione p : othello.mostraPrenotazioneCliente(codice_cliente)) {
            System.out.println(p.toString());
            cliente_presente = true;
        }
        if(cliente_presente){
            System.out.println("   Inserisci il codice della prenotazione di cui calcolare il conto: ");
            String codice_prenotazione = Parser.getInstance().read();
            boolean codice_corretto = false;
            for (Prenotazione p : othello.mostraPrenotazioneCliente(codice_cliente)) {
                if (p.getCodice().equals(codice_prenotazione)) {
                    othello.setPrenotazioneInCorso(p);
                    codice_corretto = true;
                    break;
                }
            }
            if(codice_corretto && othello.getPrenotazioneInCorso().getStatoprenotazione().equalsStato("Check-out")){
                System.out.println("Il conto del cliente " + othello.getPrenotazioneInCorso().getCliente().getNome() + " " + othello.getPrenotazioneInCorso().getCliente().getCognome() + " è: " + othello.calcolaConto(othello.getPrenotazioneInCorso()));
                Iterator i = othello.visualizzaPrenotazioni().iterator();
                while (i.hasNext()) {
                    Prenotazione p = (Prenotazione) i.next();
                    if (othello.getPrenotazioneInCorso().getCodice().equals(p.getCodice())) {
                        i.remove();
                        break;
                    }
                }
                othello.getPrenotazioneInCorso().getStatoprenotazione().gestioneStatoPrenotazione(othello.getPrenotazioneInCorso(),"Concluso");
                othello.annullaPrenotazioneInCorso();
            }else
                System.out.println("Devi effettuare il check-out prima di calcolare il conto");
        }
    }
}
