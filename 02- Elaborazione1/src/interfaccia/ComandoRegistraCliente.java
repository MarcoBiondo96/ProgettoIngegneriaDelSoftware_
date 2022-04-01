package interfaccia;

import dominio.Othello;

public class ComandoRegistraCliente implements Comando{

    public static final String codiceComando="3";
    public static final String descrizioneComando="registra cliente";

    public String getCodiceComando() {
        return codiceComando;
    }

    public String getDescrizioneComando() {
        return descrizioneComando;
    }

    public void esegui(Othello othello) {
        try{
        System.out.println("   Nome: ");
        String nome_cliente = Parser.getInstance().read();
        System.out.println("   Cognome: ");
        String cognome_cliente = Parser.getInstance().read();
        System.out.println("   Codice fiscale: ");
        String codice_cliente = Parser.getInstance().read();
        System.out.println("   Email: ");
        String email_cliente = Parser.getInstance().read();
        System.out.println("   Numero telefono: ");
        String numeroTel_cliente = Parser.getInstance().read();
        System.out.println("   Numero carta: ");
        String numeroCarta_cliente = Parser.getInstance().read();
        System.out.println();
        othello.registraCliente(nome_cliente, cognome_cliente, codice_cliente, email_cliente, numeroTel_cliente, numeroCarta_cliente);
        System.out.println("Il cliente è stato registrato");
    }catch (Exception E){
            System.out.println("ATTENZIONE! Devi prima effettuare la registrazione della stanza");
        }
    }
}
