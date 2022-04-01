package interfaccia;

import dominio.Othello;

public class NuovoServizioConsole{

    public void start(Othello othello){
        visualizza();
        Comando comando = Parser.getInstance().getComando(ElencoComandi.NUOVO_SERVIZIO);

        while (!comando.getCodiceComando().equals("0")) {
            comando.esegui(othello);
            System.out.println();
            visualizza();
            comando = Parser.getInstance().getComando(ElencoComandi.NUOVO_SERVIZIO);
        }
        comando.esegui(othello); // sicuramente � il comando esci
        System.out.println("   BYE...");
    }

    public void visualizza(){
        System.out.println("INSERIMENTO NUOVO SERVIZIO");
        System.out.println(ElencoComandi.elencoTuttiComandi(ElencoComandi.NUOVO_SERVIZIO));
        System.out.println("FAI LA TUA SCELTA");
    }

}
