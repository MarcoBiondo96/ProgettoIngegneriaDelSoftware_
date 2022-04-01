package dominio;

import javax.sound.sampled.Port;
import java.util.*;
import java.sql.Date;

public class Othello {

    private static Othello singleton;

    private List<Cliente> clienti;

    private List<Stanza> stanze;

    private List<Prenotazione> prenotazioni;

    private List<Pacchetto> pacchetti;

    private Prenotazione prenotazioneInCorso;

    private ServizioInCamera servizioInCameraInCorso;

    private List<ServizioInCamera> serviziInCamera;

    private List<Portata> portate;

    private int counter;


    public Othello() {
        this.clienti = new LinkedList<Cliente>();
        this.stanze = new LinkedList<Stanza>();
        this.prenotazioni = new LinkedList<Prenotazione>();
        this.pacchetti = new LinkedList<Pacchetto>();
        this.serviziInCamera = new LinkedList<ServizioInCamera>();
        this.portate = new LinkedList<Portata>();
        this.counter = 1; //impostare diversamente con l'uso dei file
        caricaStanze();
        caricaPacchetti();
        caricaPortate();
        //caricaPrenotazione();
    }

    public static Othello getInstance() {
        if (singleton == null)
            singleton = new Othello();
        else
            System.out.println("Istanza già creata");
        return singleton;
    }

    public void caricaStanze(){
        Stanza s1 = new Stanza("1", "singola", 1.1f);
        this.stanze.add(s1);
        Stanza s2 = new Stanza("2", "singola", 1.2f);
        this.stanze.add(s2);
        Stanza s3 = new Stanza("3", "matrimoniale", 2.1f);
        this.stanze.add(s3);
    }

    public void caricaPacchetti(){
        Pacchetto p1 = new Pacchetto("1", "mezza pensione", 1.1f);
        this.pacchetti.add(p1);
        Pacchetto p2 = new Pacchetto("2", "pensione completa", 1.3f);
        this.pacchetti.add(p2);
        Pacchetto p3 = new Pacchetto("3", "mezza pensione", 1.4f);
        this.pacchetti.add(p3);
    }

    public void caricaPortate(){
        Portata p1 = new Portata("arancino", true, 5.5f);
        this.portate.add(p1);
        Portata p2 = new Portata("arancina", false, 1.5f);
        this.portate.add(p2);
        Portata p3 = new Portata("pizza", true, 8.5f);
        this.portate.add(p3);
    }

    public Prenotazione getPrenotazioneInCorso(){ return this.prenotazioneInCorso; }

    public void setPrenotazioneInCorso(Prenotazione p){ this.prenotazioneInCorso=p; }


    public List<Stanza> visualizzaStanze(String tipologia, Date data_inizio, Date data_fine) {
        List<Stanza> tipologiaStanze = new LinkedList<Stanza>();
        List<Stanza> stanzeDisponibili = new LinkedList<Stanza>();
        for (Stanza s : this.stanze) {
            if (tipologia.equalsIgnoreCase(s.getTipologia())) {
                tipologiaStanze.add(s);
            }
        }
        for (Stanza s : tipologiaStanze) {
            if(this.prenotazioni.isEmpty()) {
                if (!data_inizio.equals(data_fine) && !data_inizio.after(data_fine)) {
                    stanzeDisponibili.add(s);
                }
            }
            boolean disponibile = true;
            for (Prenotazione p : this.prenotazioni) {
                if (!p.isDisponibile(s.getCodice(), data_inizio, data_fine)) {
                    disponibile = false;
                    break;
                }
            }
            if(disponibile && !this.prenotazioni.isEmpty())
            stanzeDisponibili.add(s);
        }
        return stanzeDisponibili;
    }


    public boolean verificaStanzaPrenotata(String codiceStanza, Date data_inizio, Date data_fine){
        boolean disponibile = true;
        if(this.prenotazioni.isEmpty())
            return disponibile;
        for (Prenotazione p : this.prenotazioni) {
            if (!p.isDisponibile(codiceStanza, data_inizio, data_fine)) {
                disponibile = false;
                break;
            }
        }
        return disponibile;
    }


    public void registraStanze(String codice) {
        Integer i = new Integer(counter);
        this.prenotazioneInCorso = new Prenotazione(i.toString());
        for (Stanza s : this.stanze) {
            if (codice.equals(s.getCodice()))
                this.prenotazioneInCorso.setStanza(s);
        }
    }

    public List<Pacchetto> visualizzaPacchetto() {
        return this.pacchetti;
    } //valutare l'utilità del metodo

    public void registraPacchetto(String codice) {
        for (Pacchetto p : this.pacchetti) {
            if (codice.equals(p.getCodice()))
                this.prenotazioneInCorso.setPacchetto(p);
        }
    }

    public void registraCliente(String nome, String cognome, String codice_fiscale, String email, String numero_telefono, String numero_carta) {
        boolean disponibile = false;
        for (Cliente c : this.clienti) {
            if (codice_fiscale.equals(c.getCodice_fiscale())) {
                disponibile = true;
                this.prenotazioneInCorso.setCliente(c); break;
            }
        }
        if (!disponibile) {
            Cliente c = new Cliente(codice_fiscale, nome, cognome, numero_telefono, email, numero_carta);
            this.clienti.add(c);
            this.prenotazioneInCorso.setCliente(c);
        }
    }


    public void registraPrenotazione(Date data_inizio, Date data_fine) {
        this.prenotazioneInCorso.setData_inizio(data_inizio);
        this.prenotazioneInCorso.setData_fine(data_fine);
        this.prenotazioni.add(this.prenotazioneInCorso);
        this.counter = this.counter + 1;
    } //verificare funzionamento e modificare SD ed eliminare metodo clone e addPrenotazione


    public List<Prenotazione> visualizzaPrenotazioni(){
        return this.prenotazioni;
    }

    public List<Cliente> visualizzaClienti(){
        return this.clienti;
    }

    public void annullaPrenotazioneInCorso(){
        this.prenotazioneInCorso = null;
    }

    public List<Prenotazione> mostraPrenotazioneCliente(String CodiceCliente){
        List<Prenotazione> prenotazioniCliente = new LinkedList<Prenotazione>();
        for(Prenotazione p : this.prenotazioni){
            if(p.getCliente().getCodice_fiscale().equalsIgnoreCase(CodiceCliente))
                prenotazioniCliente.add(p);
        }
        return prenotazioniCliente;
    }

    public List<Portata> mostraPortate(){
        List<Portata> portatedisponibili= new LinkedList<Portata>();
        for(Portata p: this.portate){
            if(p.isDisponibilita())
                portatedisponibili.add(p);
        }
        return  portatedisponibili;
    }

    public ServizioInCamera getServizioInCameraInCorso() {
        return servizioInCameraInCorso;
    }

    public void setServizioInCameraInCorso(ServizioInCamera servizioInCameraInCorso) {
        this.servizioInCameraInCorso = servizioInCameraInCorso;
    }

    public List<Stanza> getStanze() {
        return stanze;
    }


    public void creaServizioInCamera(String codCamera, Date data){
        for(Stanza s: this.getStanze()){
            if(codCamera.equalsIgnoreCase(s.getCodice())){
                this.servizioInCameraInCorso = new ServizioInCamera(data,s);
                break;
            }
        }
    }

    public void registraPortate(String nome, int quantita){
        for(Portata p: this.mostraPortate()){
            if(nome.equalsIgnoreCase(p.getNome())){
                this.getServizioInCameraInCorso().registraPortata(p,quantita);
                break;
            }
        }
    }
    public void registraServizioInCamera(){
        this.serviziInCamera.add(this.servizioInCameraInCorso);
    }

    public List<ServizioInCamera> getServiziInCamera() {
        return serviziInCamera;
    }

    public void resettaServizioInCameraInCorso(){ this.servizioInCameraInCorso = null; }
}
