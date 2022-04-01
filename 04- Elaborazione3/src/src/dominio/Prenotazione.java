package dominio;

import java.util.*;

public class Prenotazione {

    private String codice;
    private Date data_inizio, data_fine;
    private Stanza stanza;
    private Cliente cliente;
    private Pacchetto pacchetto;

    public Prenotazione(){}

    public Prenotazione(String c){
        this.codice = c;
    }

    public Prenotazione(String c, Date dataInizio, Date dataFine, Stanza s){
        this.codice = c;
        this.data_inizio = dataInizio;
        this.data_fine = dataFine;
        this.stanza = s;
    }

    public String getCodice(){ return this.codice; }

    public Date getData_inizio(){ return this.data_inizio; }

    public Date getData_fine(){ return this.data_fine; }

    public Stanza getStanza(){ return this.stanza; }

    public Cliente getCliente() { return this.cliente; }

    public void setData_inizio(Date data){ this.data_inizio = data; }

    public void setData_fine(Date data){ this.data_fine = data; }

    public void setStanza(Stanza s){ this.stanza = s; }

    public void setCliente(Cliente c){ this.cliente = c; }

    public void setPacchetto(Pacchetto p){ this.pacchetto = p; }

    public boolean isDisponibile(String codiceStanza, Date dataInizio, Date dataFine) {
        if(dataInizio.after(dataFine)){
            return false;
        }
        if(dataInizio.equals(dataFine)){
            return false;
        }
        if (this.stanza.getCodice().equals(codiceStanza)) {
            if (dataInizio.after(this.data_inizio) && dataInizio.before(this.data_fine)) {
                return false;
            }
            if (dataFine.after(this.data_inizio) && dataFine.before(this.data_fine)) {
                return false;
            }
            if (dataInizio.before(this.data_inizio) && dataFine.after(this.data_fine)) {
                return false;
            }
            if (dataInizio.equals(this.data_inizio)) {
                return false;
            }
            if (dataFine.equals(this.data_fine)) {
                return false;
            }
            if (dataInizio.equals(this.data_fine)) {
                return false;
            }
            if (dataFine.equals(this.data_inizio)) {
                return false;
            }
        }
        return true;
    }

    public String toString(){
        return "codice: " + this.codice + ", cliente: " + this.cliente.getCodice_fiscale() + ", stanza: " + this.stanza.getCodice() + ", pacchetto: " + this.pacchetto.getNome() + ", data inizio: " + this.data_inizio + ", data fine: " + this.data_fine + "\n";
    }



}
