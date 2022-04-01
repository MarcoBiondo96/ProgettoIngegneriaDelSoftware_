package interfaccia;

import dominio.Othello;
import dominio.Prenotazione;

import java.util.Iterator;

public class ComandoCancellaPrenotazione implements Comando{

    public static final String codiceComando = "2";
    public static final String descrizioneComando = "elimina prenotazione";

    public String getCodiceComando() {
        return codiceComando;
    }

    public String getDescrizioneComando() {
        return descrizioneComando;
    }

    public void esegui(Othello othello) {
        try {
            System.out.println("   Inserisci il codice fiscale del cliente: ");
            String codice_cliente = Parser.getInstance().read();
            System.out.println();
            boolean cliente_presente = false;
            for (Prenotazione p : othello.mostraPrenotazioneCliente(codice_cliente)) {
                System.out.println(p.toString());
                cliente_presente = true;
            }
            if (cliente_presente) {
                System.out.println("   Inserisci il codice della prenotazione da eliminare: ");
                String codice_prenotazione = Parser.getInstance().read();
                boolean codice_corretto = false;
                for (Prenotazione p : othello.mostraPrenotazioneCliente(codice_cliente)) {
                    if (p.getCodice().equals(codice_prenotazione)) {
                        codice_corretto = true;
                        break;
                    }
                }
                if (codice_corretto) {
                    Iterator i = othello.visualizzaPrenotazioni().iterator();
                    while (i.hasNext()) {
                        Prenotazione p = (Prenotazione) i.next();
                        if (p.getCodice().equals(codice_prenotazione)) {
                            i.remove();
                            System.out.println("Eliminazione della prenotazione effettuata");
                        }
                    }

                } else
                    System.out.println("ATTENZIONE! Codice prenotazione inserito non è valido");
            } else {
                System.out.println("Il Cliente non ha nessuna prenotazione effettuata");
            }
        }catch (Exception e){
            System.out.println("ATTENZIONE! Dati inseriti non validi");
        }
    }
}