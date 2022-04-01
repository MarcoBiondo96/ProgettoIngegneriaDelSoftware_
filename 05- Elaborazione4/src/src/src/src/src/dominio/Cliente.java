package dominio;

import java.io.Serializable;

public class Cliente implements Serializable {

    private String codice_fiscale;
    private String nome;
    private String cognome;
    private String numero_telefono;
    private String email;
    private String numero_carta;
    private boolean checkedIn;


    public Cliente(String cf, String n, String c, String nt, String e, String nc){
        this.codice_fiscale = cf;
        this.nome = n;
        this.cognome = c;
        this.numero_telefono = nt;
        this.email = e;
        this.numero_carta = nc;
    }

    public String getCodice_fiscale(){ return this.codice_fiscale; }

    public String getNome(){ return this.nome; }

    public String getCognome(){ return this.cognome; }

    public String getNumero_telefono(){ return this.numero_telefono; }

    public String getEmail(){ return this.email; }

    public String getNumero_carta(){ return this.numero_carta; }

    public void setCheckedIn(boolean checkedIn) {
        this.checkedIn = checkedIn;
    }

    public String toString(){
        return "CF: " + this.codice_fiscale + ", nome: " + this.nome + ", cognome: " + this.cognome + ", numero telefono: " + this.numero_telefono + ", email: " + this.email + ", numero carta: " + this.numero_carta;
    }

}
