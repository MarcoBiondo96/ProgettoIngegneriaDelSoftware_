package interfaccia;


class ElencoComandi {

    public static final int OTHELLO = 0;
    public static final int NUOVA_PRENOTAZIONE = 1;
    public static final int MODIFICA_PRENOTAZIONE = 2;
    public static final int NUOVO_SERVIZIO_IN_CAMERA = 3;
    public static final int NUOVO_SERVIZIO = 4;
    public static final int ADMIN = 5;
    public static final int CHECK_IN_CHECK_OUT = 6;

    /* MENU' PRINCIPALE */
    private static final String comandiValidiOthelloConsole[][] = {
            {ComandoNuovaPrenotazione.codiceComando,ComandoNuovaPrenotazione.descrizioneComando},
            {ComandoModificaPrenotazione.codiceComando,ComandoModificaPrenotazione.descrizioneComando},
            {ComandoInserisciNuovoServizioInCamera.codiceComando,ComandoInserisciNuovoServizioInCamera.descrizioneComando},
            {ComandoNuovoServizio.codiceComando,ComandoNuovoServizio.descrizioneComando},
            {ComandiAdmin.codiceComando,ComandiAdmin.descrizioneComando},
            {ComandoCheckInCheckOut.codiceComando,ComandoCheckInCheckOut.descrizioneComando},
            {ComandoVisualizzaClienti.codiceComando,ComandoVisualizzaClienti.descrizioneComando},
            {ComandoCalcolaConto.codiceComando,ComandoCalcolaConto.descrizioneComando},
            {ComandoEsci.codiceComando, ComandoEsci.descrizioneComando}
    };

    /* USE CASE 1 : INSERIMENTO NUOVA PRENOTAZIONE */
    private static final String comandiValidiNuovaPrenotazioneConsole[][] = {
            {ComandoRegistraStanze.codiceComando, ComandoRegistraStanze.descrizioneComando},
            {ComandoRegistraPacchetto.codiceComando, ComandoRegistraPacchetto.descrizioneComando},
            {ComandoRegistraCliente.codiceComando, ComandoRegistraCliente.descrizioneComando},
            {ComandoRegistraPrenotazione.codiceComando, ComandoRegistraPrenotazione.descrizioneComando},
            {ComandoAnnullaPrenotazioneInCorso.codiceComando, ComandoAnnullaPrenotazioneInCorso.descrizioneComando},
            {ComandoEsci.codiceComando, ComandoEsci.descrizioneComando}
    };

    /* USE CASE 2 : MODIFICA PRENOTAZIONE */
    private static final String comandiValidiModificaPrenotazioneConsole[][] = {
            {ComandoElencaPrenotazioni.codiceComando, ComandoElencaPrenotazioni.descrizioneComando},
            {ComandoCancellaPrenotazione.codiceComando, ComandoCancellaPrenotazione.descrizioneComando},
            {ComandoEsci.codiceComando, ComandoEsci.descrizioneComando}
    };

    /*USE CASE 3: INSERISCI NUOVO SERVIZIO IN CAMERA*/

    private static final String comandiValidiNuovoServizioInCameraConsole[][] = {
            {ComandoCreaNuovoServizioInCamera.codiceComando, ComandoCreaNuovoServizioInCamera.descrizioneComando},
            {ComandoSelezionaPortate.codiceComando, ComandoSelezionaPortate.descrizioneComando},
            {ComandoEsci.codiceComando, ComandoEsci.descrizioneComando}
    };

    /*USE CASE 4: GESTIONE SERVIZI*/

    private static final String comandiValidiNuovoServizioConsole[][] = {
            {ComandoRegistraServizio.codiceComando, ComandoRegistraServizio.descrizioneComando},
            {ComandoEsci.codiceComando, ComandoEsci.descrizioneComando}
    };

    /*CASI D'USO ADMIN*/

    private static final String comandiValidiAdminConsole[][] = {
            {ComandoDisabilitaStanze.codiceComando, ComandoDisabilitaStanze.descrizioneComando},
            {ComandoRiabilitaStanze.codiceComando, ComandoRiabilitaStanze.descrizioneComando},
            {ComandoVariazionePrezzoStanze.codiceComando, ComandoVariazionePrezzoStanze.descrizioneComando},
            {ComandoAggiuntaPortata.codiceComando, ComandoAggiuntaPortata.descrizioneComando},
            {ComandoRimozionePortata.codiceComando, ComandoRimozionePortata.descrizioneComando},
            {ComandoAggiungiPacchetto.codiceComando, ComandoAggiungiPacchetto.descrizioneComando},
            {ComandoModificaPacchetto.codiceComando, ComandoModificaPacchetto.descrizioneComando},
            {ComandoCancellaPacchetto.codiceComando, ComandoCancellaPacchetto.descrizioneComando},
            {ComandoEsci.codiceComando, ComandoEsci.descrizioneComando}
    };

    /*USE CASE 11: CHECK-IN/CHECK-OUT*/

    private static final String comandiValidiCheckInCheckOutConsole[][] = {
            {ComandoCheckIn.codiceComando, ComandoCheckIn.descrizioneComando},
            {ComandoCheckOut.codiceComando, ComandoCheckOut.descrizioneComando},
            {ComandoEsci.codiceComando, ComandoEsci.descrizioneComando}
    };


    public static String elencoTuttiComandi(int console){
        int i=0;
        StringBuffer elenco = new StringBuffer();
        String comandi[][]=getComandi(console);


        for (i=0; i<comandi.length-1; i++) {
            elenco.append(comando(i,console));
            elenco.append("\n");
        }
        elenco.append(comando(i,console));
        return elenco.toString();
    }

    private static String comando(int i, int console) {
        String comandi[][]= getComandi(console);
        return " " + comandi[i][0] + ")" + comandi[i][1];
    }

    public static String[][] getComandi(int console){

        String comandi[][]=null;

        switch (console){
            case OTHELLO: comandi = comandiValidiOthelloConsole; break;
            case NUOVA_PRENOTAZIONE: comandi = comandiValidiNuovaPrenotazioneConsole; break;
            case MODIFICA_PRENOTAZIONE: comandi = comandiValidiModificaPrenotazioneConsole; break;
            case NUOVO_SERVIZIO_IN_CAMERA: comandi = comandiValidiNuovoServizioInCameraConsole; break;
            case NUOVO_SERVIZIO: comandi = comandiValidiNuovoServizioConsole; break;
            case ADMIN: comandi = comandiValidiAdminConsole; break;
            case CHECK_IN_CHECK_OUT: comandi = comandiValidiCheckInCheckOutConsole; break;
        };
        return comandi;
    }

    public boolean comandoValido(String stringa, int console) {
        String comandi[][]= getComandi(console);
        for(int i = 0; i < comandi.length; i++) {
            if(comandi[i][0].equals(stringa))
                return true;
        }
        return false;
    }

}
