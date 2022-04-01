package interfaccia;

import dominio.Cliente;
import dominio.Othello;
import dominio.Prenotazione;

import java.io.FileNotFoundException;
import java.util.Iterator;

public class ComandoCheckOut implements Comando{

    public static final String codiceComando="2";
    public static final String descrizioneComando="check out";

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
            if(p.getStatoprenotazione().equalsStato("Check-in")) {
                System.out.println(p.toString());
                cliente_presente = true;
            }
        }
        if(cliente_presente ){
            System.out.println("   Inserisci il codice della prenotazione di cui effettuare il check-out: ");
            String codice_prenotazione = Parser.getInstance().read();
            boolean codice_corretto = false;
            for (Prenotazione p : othello.mostraPrenotazioneCliente(codice_cliente)) {
                if (p.getCodice().equals(codice_prenotazione)) {
                    codice_corretto = true;
                    othello.setPrenotazioneInCorso(p);
                    break;
                }
            }
            if(codice_corretto && othello.getPrenotazioneInCorso().getStatoprenotazione().equalsStato("Check-in")){
                Iterator i = othello.visualizzaPrenotazioni().iterator();
                while (i.hasNext()) {
                    Prenotazione p = (Prenotazione) i.next();
                    if (othello.getPrenotazioneInCorso().getCodice().equals(p.getCodice())) {
                        i.remove();
                        break;
                    }
                }
                othello.getPrenotazioneInCorso().getStatoprenotazione().gestioneStatoPrenotazione(othello.getPrenotazioneInCorso(),"Check-out");
                othello.visualizzaPrenotazioni().add(othello.getPrenotazioneInCorso());
                System.out.println("Il Check-out è stato effettuato");
                try {
                    othello.storePrenotazioni();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                othello.annullaPrenotazioneInCorso();
            }else{
                System.out.println("Il codice non è corretto o il check-out non è applicabile");
                othello.annullaPrenotazioneInCorso();
            }
        }else
            System.out.println("Il cliente non è presente");
    }
}
