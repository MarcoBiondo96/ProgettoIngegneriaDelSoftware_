package interfaccia;

import dominio.Othello;
import dominio.Pacchetto;
import dominio.Portata;
import dominio.Servizio;

import java.io.FileNotFoundException;

public class ComandoAggiungiPacchetto implements Comando{
    public static final String codiceComando="6";
    public static final String descrizioneComando="aggiungi pacchetto";

    public String getCodiceComando() {
        return codiceComando;
    }

    public String getDescrizioneComando() {
        return descrizioneComando;
    }

    public void esegui(Othello othello) {
        boolean esiste = false;
        System.out.println("   Inserisci il nome del pacchetto d'aggiungere: ");
        String nome = Parser.getInstance().read();
        for(Pacchetto p : othello.visualizzaPacchetto()){
            if(p.getNome().equalsIgnoreCase(nome)){
                esiste = true;
                break;
            }
        }
        if(esiste){
           System.out.println("Pacchetto già esistente");
        }else{
            System.out.println("   Inserisci il prezzo del pacchetto d'aggiungere: ");
            String prezzo = Parser.getInstance().read();
            String codice = othello.getCounterPacchetto();
            Pacchetto p = new Pacchetto(codice, nome, Float.valueOf(prezzo));
            for(Servizio s : othello.getServizi()){
                System.out.println(s.toString());
            }
            while(true) {
                System.out.println("   Inserisci il nome del servizio d'aggiungere (0 per uscire): ");
                String nomeP = Parser.getInstance().read();
                boolean ok = false;
                if(nomeP.equalsIgnoreCase("0"))
                    break;
                for(Servizio s : othello.getServizi()){
                    if(s.getTipo().equalsIgnoreCase(nomeP)){
                        ok = true;
                        if(p.getServizi().isEmpty()) {
                            p.getServizi().add(s);
                            break;
                        }else{
                            boolean trovato = false;
                            for(Servizio sv : p.getServizi()){
                                if(sv.getTipo().equalsIgnoreCase(nomeP)){
                                    trovato = true;
                                }
                            }
                            if(trovato) {
                                System.out.println("Servizio già presente");
                                break;
                            }else{
                                p.getServizi().add(s);
                                break;
                            }
                        }
                    }
                }
            }
            othello.visualizzaPacchetto().add(p);
            try {
                othello.storePacchetti();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            System.out.println("Pacchetto inserito");
        }
    }
}
