package interfaccia;

import dominio.Othello;

public class OthelloConsole {

    public void start(){
        Othello othello = new Othello();
        visualizza();
        Comando comando = Parser.getInstance().getComando(ElencoComandi.OTHELLO);

        while (!comando.getCodiceComando().equals("0")) {
            comando.esegui(othello);
            System.out.println();
            visualizza();
            comando = Parser.getInstance().getComando(ElencoComandi.OTHELLO);
        }
        comando.esegui(othello); // sicuramente � il comando esci
        System.out.println("   BYE...");
    }

    public void visualizza(){
        System.out.println("OTHELLO");
        System.out.println(ElencoComandi.elencoTuttiComandi(ElencoComandi.OTHELLO));
        System.out.println("FAI LA TUA SCELTA");
    }
}
