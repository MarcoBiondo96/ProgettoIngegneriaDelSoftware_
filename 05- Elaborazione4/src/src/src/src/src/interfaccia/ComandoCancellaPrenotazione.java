package interfaccia;

import dominio.Othello;
import dominio.Prenotazione;

import java.sql.Date;
import java.time.LocalDate;
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
                if(p.getStatoprenotazione().equalsStato("Creato")) {
                    System.out.println(p.toString());
                    cliente_presente = true;
                }
            }
            if (cliente_presente) {
                System.out.println("   Inserisci il codice della prenotazione da eliminare: ");
                String codice_prenotazione = Parser.getInstance().read();
                boolean codice_corretto = false;
                for (Prenotazione p : othello.mostraPrenotazioneCliente(codice_cliente)) {
                    if (p.getCodice().equals(codice_prenotazione)) {
                        codice_corretto = true;
                        othello.setPrenotazioneInCorso(p);
                        break;
                    }
                }
                if (codice_corretto && othello.getPrenotazioneInCorso().getStatoprenotazione().equalsStato("Creato")) {
                    LocalDate d = LocalDate.now();
                    Date ds = Date.valueOf(d.toString());
                    Date dp = (Date) othello.getPrenotazioneInCorso().getData_inizio();
                    int dataIn = (int) ((ds.getTime()) / (86400000)) % 365;
                    int dataFn = (int) ((dp.getTime()) / (86400000)) % 365;
                    int giorniTotali = (dataFn - dataIn) + 1;
                    if (giorniTotali > 3) {
                        Iterator i = othello.visualizzaPrenotazioni().iterator();
                        while (i.hasNext()) {
                            Prenotazione p = (Prenotazione) i.next();
                            if (p.getCodice().equals(codice_prenotazione)) {
                                i.remove();
                                othello.storePrenotazioni();//controlla
                                System.out.println("Eliminazione della prenotazione effettuata");
                            }
                        }
                    }else{
                        System.out.println("Giorni massimi per la modifica superati");
                        othello.annullaPrenotazioneInCorso();
                    }

                } else
                    System.out.println("ATTENZIONE! Codice prenotazione inserito non è valido");
            } else {
                System.out.println("Il Cliente non ha nessuna prenotazione effettuata");
            }
        }catch (Exception e){
            System.out.println("ATTENZIONE! Dati inseriti non validi");
            e.printStackTrace();
        }
    }
}