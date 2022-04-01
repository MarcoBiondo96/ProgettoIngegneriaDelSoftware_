package interfaccia;

import dominio.Othello;
import dominio.Prenotazione;

import java.io.FileNotFoundException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Iterator;

public class ComandoElencaPrenotazioni implements Comando{

    public static final String codiceComando = "1";
    public static final String descrizioneComando = "modifica prenotazione";

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
                System.out.println("   Inserisci il codice della prenotazione da modificare: ");
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
                        System.out.println("   Inserisci una nuova data d'inizio: ");
                        String dataI = Parser.getInstance().read();
                        System.out.println("   Inserisci una nuova data di fine: ");
                        String dataF = Parser.getInstance().read();
                        Iterator i = othello.visualizzaPrenotazioni().iterator();
                        while (i.hasNext()) {
                            Prenotazione p = (Prenotazione) i.next();
                            if (p.getCodice().equals(codice_prenotazione))
                                i.remove();
                        }
                        boolean disponibile = true;
                        for (Prenotazione p : othello.visualizzaPrenotazioni()) {
                            if (!p.isDisponibile(othello.getPrenotazioneInCorso().getStanza().getCodice(), Date.valueOf(dataI), Date.valueOf(dataF))) {
                                disponibile = false;
                            }
                        }
                        if (disponibile) {
                            othello.getPrenotazioneInCorso().setData_inizio(Date.valueOf(dataI));
                            othello.getPrenotazioneInCorso().setData_fine(Date.valueOf(dataF));
                            othello.visualizzaPrenotazioni().add(othello.getPrenotazioneInCorso());
                            othello.storePrenotazioni();
                            System.out.println("La prenotazione è stata modificata");
                        } else {
                            othello.visualizzaPrenotazioni().add(othello.getPrenotazioneInCorso());
                            othello.storePrenotazioni();
                            System.out.println("Data non disponibile");
                            othello.annullaPrenotazioneInCorso();
                        }
                    }else{
                        System.out.println("Non è più possibile effettuare la modifica");
                        othello.annullaPrenotazioneInCorso();
                    }
                } else {
                    System.out.println("ATTENZIONE! Codice prenotazione inserito non è valido");
                    othello.annullaPrenotazioneInCorso();
                }
            } else {
                    System.out.println("Il Cliente non ha nessuna prenotazione effettuata");
                    othello.annullaPrenotazioneInCorso();
            }
        }catch (Exception e){
            System.out.println("ATTENZIONE! Dati inseriti non validi");
            othello.visualizzaPrenotazioni().add(othello.getPrenotazioneInCorso());
            try {
                othello.storePrenotazioni();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
            othello.annullaPrenotazioneInCorso();
        }
    }
}
