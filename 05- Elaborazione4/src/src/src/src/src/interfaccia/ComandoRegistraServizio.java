package interfaccia;

import dominio.*;

import java.sql.Date;
import java.util.Iterator;

public class ComandoRegistraServizio implements Comando{

    public static final String codiceComando="1";
    public static final String descrizioneComando="registra servizio";

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
                System.out.println("   Inserisci il codice della prenotazione a cui aggiungere il servizio: ");
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
                    for(Servizio s: othello.getServizi()){
                        System.out.println(s.toString());
                    }
                    System.out.println("   Inserisci 1) per inserire un servizio, 2) per inserire entrambi, 0) per annullare: ");
                    String scelta = Parser.getInstance().read();
                    int iq = Integer.parseInt(scelta);
                    boolean inserimento = false;
                    switch(iq){
                        case 0: break;
                        case 1:
                            System.out.println("   Inserisci il nome del servizio da aggiungere: ");
                            String serv1 = Parser.getInstance().read();
                            System.out.println("   Inserisci una data d'inizio: ");
                            String dataI = Parser.getInstance().read();
                            System.out.println("   Inserisci una data di fine: ");
                            String dataF = Parser.getInstance().read();
                            for(Servizio s: othello.getServizi()){
                                if(s.getTipo().equalsIgnoreCase(serv1)){
                                    System.out.println(othello.getPrenotazioneInCorso().toString());
                                    if((othello.getPrenotazioneInCorso().getData_inizio().equals(Date.valueOf(dataI)) ||
                                            (othello.getPrenotazioneInCorso().getData_inizio().before(Date.valueOf(dataI)) &&
                                            othello.getPrenotazioneInCorso().getData_fine().after(Date.valueOf(dataI)))) &&
                                            ( othello.getPrenotazioneInCorso().getData_fine().equals(Date.valueOf(dataF))  ||
                                                    (othello.getPrenotazioneInCorso().getData_fine().after(Date.valueOf(dataF)) &&
                                            othello.getPrenotazioneInCorso().getData_inizio().before(Date.valueOf(dataF)))) &&
                                            Date.valueOf(dataF).after(Date.valueOf(dataI))){
                                        RichiestaDiServizio rs = new RichiestaDiServizio(Date.valueOf(dataI), Date.valueOf(dataF));
                                        rs.setServizio(s);
                                        othello.getPrenotazioneInCorso().getRichiesteServizi().add(rs);
                                        System.out.println("Servizio: " + s.getTipo() + " inserito.");
                                        inserimento = true;
                                        break;
                                    } else {
                                        System.out.println("Data inserita non è disponibile o valida");
                                        break;
                                    }
                                }
                            }
                        case 2:
                                System.out.println("   Inserisci una data d'inizio: ");
                                String data_inizio = Parser.getInstance().read();
                                System.out.println("   Inserisci una data di fine: ");
                                String data_fine = Parser.getInstance().read();
                            if((othello.getPrenotazioneInCorso().getData_inizio().equals(Date.valueOf(data_inizio)) ||
                                    (othello.getPrenotazioneInCorso().getData_inizio().before(Date.valueOf(data_inizio)) &&
                                            othello.getPrenotazioneInCorso().getData_fine().after(Date.valueOf(data_inizio)))) &&
                                    ( othello.getPrenotazioneInCorso().getData_fine().equals(Date.valueOf(data_fine))  ||
                                            (othello.getPrenotazioneInCorso().getData_fine().after(Date.valueOf(data_fine)) &&
                                                    othello.getPrenotazioneInCorso().getData_inizio().before(Date.valueOf(data_fine)))) &&
                                    Date.valueOf(data_fine).after(Date.valueOf(data_inizio))){
                                RichiestaDiServizio rs = new RichiestaDiServizio(Date.valueOf(data_inizio), Date.valueOf(data_fine));
                                for(Servizio s : othello.getServizi()){
                                    rs.setServizio(s);
                                    othello.getPrenotazioneInCorso().getRichiesteServizi().add(rs);
                                    System.out.println("Servizio: " + s.getTipo() + " inserito.");
                                }
                                inserimento = true;
                            } else {
                                System.out.println("Data inserita non è disponibile o valida");
                                break;
                            }
                    }
                    if(inserimento){
                        Iterator i = othello.visualizzaPrenotazioni().iterator();
                        while (i.hasNext()) {
                            Prenotazione p = (Prenotazione) i.next();
                            if (p.getCodice().equals(othello.getPrenotazioneInCorso().getCodice()))
                                i.remove();
                        }
                        othello.visualizzaPrenotazioni().add(othello.getPrenotazioneInCorso());
                        othello.storePrenotazioni();
                        othello.annullaPrenotazioneInCorso();
                    }else{
                        othello.annullaPrenotazioneInCorso();
                    }
                }else{
                    othello.annullaPrenotazioneInCorso();
                    System.out.println("Codice della prenotazione inesistente.");
                }
            }else{
                System.out.println("Il codice fiscale del cliente non è presente.");
                othello.annullaPrenotazioneInCorso();
            }
        }catch (Exception e){
            System.out.println("ATTENZIONE! Dati inseriti non validi");
            othello.annullaPrenotazioneInCorso();
        }
    }
}
