package interfaccia;

import dominio.Othello;

public class ComandiAdminConsole {

    public void start(Othello othello){
        visualizza();
        Comando comando = Parser.getInstance().getComando(ElencoComandi.ADMIN);

        while (!comando.getCodiceComando().equals("0")) {
            comando.esegui(othello);
            System.out.println();
            visualizza();
            comando = Parser.getInstance().getComando(ElencoComandi.ADMIN);
        }
        comando.esegui(othello); // sicuramente � il comando esci
        System.out.println("   BYE...");
    }

    public void visualizza(){
        System.out.println("COMANDI ADMIN");
        System.out.println(ElencoComandi.elencoTuttiComandi(ElencoComandi.ADMIN));
        System.out.println("FAI LA TUA SCELTA");
    }
}
