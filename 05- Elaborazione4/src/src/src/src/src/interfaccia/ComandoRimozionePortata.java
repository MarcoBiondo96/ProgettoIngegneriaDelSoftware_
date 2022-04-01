package interfaccia;

import dominio.Othello;
import dominio.Portata;

public class ComandoRimozionePortata implements Comando{

    public static final String codiceComando="5";
    public static final String descrizioneComando="rimuovi portata";

    public String getCodiceComando() {
        return codiceComando;
    }

    public String getDescrizioneComando() {
        return descrizioneComando;
    }

    public void esegui(Othello othello) {
        try{
            for(Portata p : othello.getPortate()) {
                System.out.println(p.toString());
            }
            System.out.println("   Inserisci il nome della portata da rimuovere: ");
            String nome = Parser.getInstance().read();
            boolean presente = false;
            for(Portata p : othello.getPortate()){
                if(p.getNome().equals(nome)) {
                    presente = true;
                    othello.modificaPortata(nome, false);
                    System.out.println("Rimozione effettuata");
                }
            }
            if(!presente)
                System.out.println("Portata non presente nel menù");
        }catch(Exception E){
            System.out.println("");
        }
    }
}
