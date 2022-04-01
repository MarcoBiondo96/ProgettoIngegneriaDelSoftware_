package interfaccia;

import dominio.Othello;

public class NuovaPrenotazioneConsole {

    public void start(Othello othello){
        visualizza();
        Comando comando = Parser.getInstance().getComando(ElencoComandi.NUOVA_PRENOTAZIONE);

        while (!comando.getCodiceComando().equals("0")) {
            comando.esegui(othello);
            System.out.println();
            visualizza();
            comando = Parser.getInstance().getComando(ElencoComandi.NUOVA_PRENOTAZIONE);
        }
        comando.esegui(othello); // sicuramente � il comando esci
        System.out.println("   BYE...");
    }

    public void visualizza(){
        System.out.println("INSERIMENTO NUOVA PRENOTAZIONE");
        System.out.println(ElencoComandi.elencoTuttiComandi(ElencoComandi.NUOVA_PRENOTAZIONE));
        System.out.println("FAI LA TUA SCELTA");
    }
}
