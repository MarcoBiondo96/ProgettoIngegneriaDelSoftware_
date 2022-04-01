package interfaccia;

import dominio.Othello;
import dominio.Portata;

import java.io.FileNotFoundException;

public class ComandoAggiuntaPortata implements Comando{
    public static final String codiceComando="4";
    public static final String descrizioneComando="aggiungi portata";

    public String getCodiceComando() {
        return codiceComando;
    }

    public String getDescrizioneComando() {
        return descrizioneComando;
    }

    public void esegui(Othello othello) {
        try{
            for(Portata p : othello.getPortate()) {
                System.out.println(p.toString());
            }
            System.out.println("   Inserisci il nome della portata d'aggiungere: ");
            String nome = Parser.getInstance().read();
            boolean presente = false;
            boolean k = false;
            for(Portata p : othello.getPortate()) {
                if(p.getNome().equalsIgnoreCase(nome)) {
                    presente = true;
                    if(p.isDisponibilita() != true) {
                        k = true;
                        othello.modificaPortata(p.getNome(), true);
                        try {
                            othello.storePortate();
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            if(presente){
                if(k)
                    System.out.println("Portata riabilitata");
                else
                    System.out.println("Portata già presente");
            }else{
                System.out.println("   Inserisci il prezzo della portata d'aggiungere: ");
                String prezzo = Parser.getInstance().read();
                othello.inserisciPortata(nome, Float.valueOf(prezzo));
                try {
                    othello.storePortate();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }catch(Exception E){
            System.out.println("");
        }
    }
}
