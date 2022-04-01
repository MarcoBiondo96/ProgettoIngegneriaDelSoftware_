package interfaccia;


class ElencoComandi {

    public static final int OTHELLO = 0;
    public static final int NUOVA_PRENOTAZIONE = 1;
    public static final int MODIFICA_PRENOTAZIONE = 2;

    /* MENU' PRINCIPALE */
    private static final String comandiValidiOthelloConsole[][] = {
            {ComandoNuovaPrenotazione.codiceComando,ComandoNuovaPrenotazione.descrizioneComando},
            {ComandoModificaPrenotazione.codiceComando,ComandoModificaPrenotazione.descrizioneComando},
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
