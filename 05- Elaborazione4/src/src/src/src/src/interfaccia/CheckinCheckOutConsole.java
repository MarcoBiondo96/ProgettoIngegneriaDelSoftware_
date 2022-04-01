package interfaccia;

import dominio.Othello;

public class CheckinCheckOutConsole {

    public void start(Othello othello){
        visualizza();
        Comando comando = Parser.getInstance().getComando(ElencoComandi.CHECK_IN_CHECK_OUT);

        while (!comando.getCodiceComando().equals("0")) {
            comando.esegui(othello);
            System.out.println();
            visualizza();
            comando = Parser.getInstance().getComando(ElencoComandi.CHECK_IN_CHECK_OUT);
        }
        comando.esegui(othello); // sicuramente � il comando esci
        System.out.println("   BYE...");
    }

    public void visualizza(){
        System.out.println("INSERIMENTO NUOVO SERVIZIO");
        System.out.println(ElencoComandi.elencoTuttiComandi(ElencoComandi.CHECK_IN_CHECK_OUT));
        System.out.println("FAI LA TUA SCELTA");
    }
}
