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
                if (parola.equals("2"))
                    comando = new ComandoModificaPrenotazione();
                if (parola.equalsIgnoreCase("3"))
                    comando = new ComandoInserisciNuovoServizioInCamera();
                if (parola.equalsIgnoreCase("4"))
                    comando = new ComandoNuovoServizio();
                if (parola.equalsIgnoreCase("5"))
                    comando = new ComandiAdmin();
                if (parola.equalsIgnoreCase("6"))
                    comando = new ComandoCheckInCheckOut();
                if (parola.equalsIgnoreCase("7"))
                    comando = new ComandoVisualizzaClienti();
                if (parola.equalsIgnoreCase("8"))
                    comando = new ComandoCalcolaConto();
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
                if (parola.equals("5"))
                    comando = new ComandoAnnullaPrenotazioneInCorso();
            }

            /* MODIFICA PRENOTAZIONE */
            if (console == ElencoComandi.MODIFICA_PRENOTAZIONE){
                if (parola.equals("1"))
                    comando = new ComandoElencaPrenotazioni();
                if (parola.equals("2"))
                    comando = new ComandoCancellaPrenotazione();
            }

            /*INSERISCI NUOVO SERVIZIO IN CAMERA*/
            if (console == ElencoComandi.NUOVO_SERVIZIO_IN_CAMERA){
                if (parola.equals("1"))
                    comando = new ComandoCreaNuovoServizioInCamera();
                if (parola.equals("2"))
                    comando = new ComandoSelezionaPortate();
            }

            /*GESTIONE SERVIZI*/
            if (console == ElencoComandi.NUOVO_SERVIZIO){
                if (parola.equals("1"))
                    comando = new ComandoRegistraServizio();
            }

            /*ADMIN*/
            if (console == ElencoComandi.ADMIN){
                if (parola.equals("1"))
                    comando = new ComandoDisabilitaStanze();
                if (parola.equals("2"))
                    comando = new ComandoRiabilitaStanze();
                if (parola.equals("3"))
                    comando = new ComandoVariazionePrezzoStanze();
                if (parola.equals("4"))
                    comando = new ComandoAggiuntaPortata();
                if (parola.equals("5"))
                    comando = new ComandoRimozionePortata();
                if (parola.equals("6"))
                    comando = new ComandoAggiungiPacchetto();
                if (parola.equals("7"))
                    comando = new ComandoModificaPacchetto();
                if (parola.equals("8"))
                    comando = new ComandoCancellaPacchetto();
            }

            /*USE CASE 11: CHECK-IN/CHECK-OUT*/
            if (console == ElencoComandi.CHECK_IN_CHECK_OUT){
                if (parola.equals("1"))
                    comando = new ComandoCheckIn();
                if (parola.equals("2"))
                    comando = new ComandoCheckOut();
            }



            if (parola.equals("0"))
                comando = new ComandoEsci();


        } else comando = new ComandoNonValido();

        return comando;
    }


}
