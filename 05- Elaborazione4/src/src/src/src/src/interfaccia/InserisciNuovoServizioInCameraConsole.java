package interfaccia;

import dominio.Othello;

public class InserisciNuovoServizioInCameraConsole {

    public void start(Othello othello){
        visualizza();
        Comando comando = Parser.getInstance().getComando(ElencoComandi.NUOVO_SERVIZIO_IN_CAMERA);

        while (!comando.getCodiceComando().equals("0")) {
            comando.esegui(othello);
            System.out.println();
            visualizza();
            comando = Parser.getInstance().getComando(ElencoComandi.NUOVO_SERVIZIO_IN_CAMERA);
        }
        comando.esegui(othello); // sicuramente � il comando esci
        System.out.println("   BYE...");
    }

    public void visualizza(){
        System.out.println("INSERISCI SERVIZIO IN CAMERA");
        System.out.println(ElencoComandi.elencoTuttiComandi(ElencoComandi.NUOVO_SERVIZIO_IN_CAMERA));
        System.out.println("FAI LA TUA SCELTA");
    }
}
