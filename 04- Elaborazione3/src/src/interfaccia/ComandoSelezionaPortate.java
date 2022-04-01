package interfaccia;

import dominio.Othello;
import dominio.Portata;
import dominio.QuantitaPortata;

public class ComandoSelezionaPortate implements Comando{

    public static final String codiceComando = "2";
    public static final String descrizioneComando = "seleziona portate";

    public String getCodiceComando() {
        return codiceComando;
    }

    public String getDescrizioneComando() {
        return descrizioneComando;
    }

    public void esegui(Othello othello) {
        boolean ordine_creato = false;
        if (othello.getServizioInCameraInCorso() != null) {
            while (true) {
                try {
                    System.out.println();
                    for (Portata p : othello.mostraPortate()) {
                        System.out.println(p.toString());
                    }
                    System.out.println();
                    System.out.println("Inserisci il nome della portata da ordinare o 0 per terminare l'inserimento delle portate: ");
                    String nome_portata = Parser.getInstance().read();
                    if (nome_portata.equals("0"))
                        break;
                    for (Portata p : othello.mostraPortate()) {
                        if (nome_portata.equalsIgnoreCase(p.getNome())) {
                            System.out.println("Inserisci la quantita: ");
                            String quantita = Parser.getInstance().read();
                            int iq = Integer.parseInt(quantita);
                            othello.getServizioInCameraInCorso().registraPortata(p, iq);
                            System.out.println("Portata inserita in ordine");
                            ordine_creato = true;
                            break;
                        } else {
                            System.out.println("Portata non disponibile");
                            break;
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Quantita inserita non valida");
                }
            }
            if(ordine_creato) {
                othello.getServiziInCamera().add(othello.getServizioInCameraInCorso());
                System.out.println("Ordine registrato nel servizio in camera");
                othello.resettaServizioInCameraInCorso();
            } else{
                othello.resettaServizioInCameraInCorso();
                System.out.println("Non è stata selezionata nessuna portata. Il servizio in camera è stato cancellato");
            }
        } else
            System.out.println("ATTENZIONE! Deve essere selezionata la stanza su cui effettuare il servizio in camera");
    }
}
