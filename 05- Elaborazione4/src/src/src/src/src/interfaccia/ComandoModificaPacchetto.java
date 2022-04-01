package interfaccia;

import dominio.Othello;
import dominio.Pacchetto;
import dominio.Prenotazione;

import java.io.FileNotFoundException;
import java.sql.Date;
import java.util.Iterator;

public class ComandoModificaPacchetto implements Comando{
    public static final String codiceComando = "7";
    public static final String descrizioneComando = "modifica pacchetto";

    public String getCodiceComando() {
        return codiceComando;
    }

    public String getDescrizioneComando() {
        return descrizioneComando;
    }

    public void esegui(Othello othello) {

        for(Pacchetto p : othello.visualizzaPacchetto()){
            System.out.println(p.toString());
        }
        System.out.println("Inserisci il codice del pacchetto da modificare: ");
        String codice_pacchetto = Parser.getInstance().read();
        boolean trovato = false;
        Iterator i = othello.visualizzaPacchetto().iterator();
        while (i.hasNext()) {
            Pacchetto p = (Pacchetto) i.next();
            if(codice_pacchetto.equals("1") || codice_pacchetto.equals("2") || codice_pacchetto.equals("3")){
                trovato = true;
                System.out.println("Pacchetto non modificabile");
                break;
            }
            if (p.getCodice().equals(codice_pacchetto)) {
                trovato = true;
                i.remove();
                System.out.println("Inserisci un nuovo prezzo del pacchetto: ");
                String prezzo_pacchetto = Parser.getInstance().read();
                p.setPrezzo(Float.valueOf(prezzo_pacchetto));
                othello.visualizzaPacchetto().add(p);
                System.out.println("Pacchetto modificato");
                try {
                    othello.storePacchetti();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
        if(trovato == false)
            System.out.println("Pacchetto non presente");
    }
}
