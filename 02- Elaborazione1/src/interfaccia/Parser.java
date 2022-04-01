package interfaccia;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Parser {

    private ElencoComandi comandi;
    private static Parser singleton;

    public Parser() {
        comandi = new ElencoComandi();
    }

    public static Parser getInstance() {
        if (singleton==null)
            singleton=new Parser();
        return singleton;
    }

    public String read() {
        String inputLine = "";

        System.out.print(" > ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            inputLine = reader.readLine();
        }
        catch(java.io.IOException exc) {
            System.out.println ("Errore durante la lettura: " + exc.getMessage());
        }
        return inputLine;
    }

    public Comando getComando(int console) {
        String parola = read();
        Comando comando = null;

        if(comandi.comandoValido(parola,console)) {
            /* CONSOLE PRINCIPALE */
            if (console == ElencoComandi.OTHELLO){
                if (parola.equals("1"))
                    comando = new ComandoNuovaPrenotazione();
            }


            /* NUOVA PRENOTAZIONE*/
            if (console == ElencoComandi.NUOVA_PRENOTAZIONE){
                if (parola.equals("1"))
                    comando = new ComandoRegistraStanze();
                if (parola.equals("2"))
                    comando = new ComandoRegistraPacchetto();
                if (parola.equals("3"))
                    comando = new ComandoRegistraCliente();
                if (parola.equals("4"))
                    comando = new ComandoRegistraPrenotazione();
            }
    /*

            if (console == ElencoComandi.NUOVO_ORDINE){
                if (parola.equals("1"))
                    comando = new ComandoNuovaColazione();
                if (parola.equals("2"))
                    comando = new ComandoDefinisciModoServizio();
                if (parola.equals("3"))
                    comando = new ComandoAssociaOrdineCliente();
                if (parola.equals("4"))
                    comando = new ComandoConfermaOrdine();
            }

*/
            if (parola.equals("0"))
                comando = new ComandoEsci();
        } else comando = new ComandoNonValido();

        return comando;
    }


}
