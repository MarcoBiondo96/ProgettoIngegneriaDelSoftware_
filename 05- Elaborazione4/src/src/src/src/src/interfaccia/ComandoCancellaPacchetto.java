package interfaccia;

import dominio.Othello;
import dominio.Pacchetto;

import java.io.FileNotFoundException;
import java.util.Iterator;

public class ComandoCancellaPacchetto implements Comando{
    public static final String codiceComando = "8";
    public static final String descrizioneComando = "cancella pacchetto";

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
        System.out.println("Inserisci il codice del pacchetto da cancellare: ");
        String codice_pacchetto = Parser.getInstance().read();
        boolean trovato = false;
        Iterator i = othello.visualizzaPacchetto().iterator();
        while (i.hasNext()) {
            Pacchetto p = (Pacchetto) i.next();
            if(codice_pacchetto.equals("1") || codice_pacchetto.equals("2") || codice_pacchetto.equals("3")){
                trovato = true;
                System.out.println("Pacchetto non cancellabile");
                break;
            }
            if (p.getCodice().equals(codice_pacchetto)) {
                trovato = true;
                i.remove();
                System.out.println("Pacchetto cancellato");
                try {
                    othello.storePacchetti();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
        if(!trovato)
            System.out.println("Pacchetto non presente");
    }
}
