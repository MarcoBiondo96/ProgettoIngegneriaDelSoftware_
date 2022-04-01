package interfaccia;

import dominio.Othello;

public class ModificaPrenotazioneConsole {

    public void start(Othello othello){
        visualizza();
        Comando comando = Parser.getInstance().getComando(ElencoComandi.MODIFICA_PRENOTAZIONE);

        while (!comando.getCodiceComando().equals("0")) {
            comando.esegui(othello);
            System.out.println();
            visualizza();
            comando = Parser.getInstance().getComando(ElencoComandi.MODIFICA_PRENOTAZIONE);
        }
        comando.esegui(othello); // sicuramente � il comando esci
        System.out.println("   BYE...");
    }

    public void visualizza(){
        System.out.println("MODIFICA PRENOTAZIONE");
        System.out.println(ElencoComandi.elencoTuttiComandi(ElencoComandi.MODIFICA_PRENOTAZIONE));
        System.out.println("FAI LA TUA SCELTA");
    }
}
