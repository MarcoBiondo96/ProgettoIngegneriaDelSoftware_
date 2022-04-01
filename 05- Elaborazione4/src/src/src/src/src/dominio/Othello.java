package dominio;

import interfaccia.VariazioneStrategyFactory;
import interfaccia.VariazioneStrategyInterface;

import java.io.*;
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

    private List<Servizio> servizi;

    private List<PeriodoVariazione> periodiVariazione;


    private int counter;


    public static Othello getInstance() {
        if (singleton == null)
            singleton = new Othello();
        else
            System.out.println("Istanza già creata");

        return singleton;
    }

    public Othello() {
        this.clienti = new LinkedList<Cliente>();
        this.stanze = new LinkedList<Stanza>();
        this.prenotazioni = new LinkedList<Prenotazione>();
        this.pacchetti = new LinkedList<Pacchetto>();
        this.serviziInCamera = new LinkedList<ServizioInCamera>();//
        this.portate = new LinkedList<Portata>();
        this.servizi = new LinkedList<Servizio>();
        this.periodiVariazione = new LinkedList<PeriodoVariazione>();
        try {
            caricaClienti();
        } catch (FileNotFoundException e) {
            try {
                storeClienti();
            } catch (FileNotFoundException ex) {
            }
        }
        //storeStanze();
        try {
            caricaStanze();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            caricaPrenotazioni();
        } catch (FileNotFoundException e) {
            try {
                storePrenotazioni();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        }
        if(this.prenotazioni.isEmpty()) {
            this.counter = 1;
            //System.out.println("vuota");
        } else{
            int i=1;
            for(Prenotazione p:this.prenotazioni){
                if(Integer.parseInt(p.getCodice()) > i){
                    i=Integer.parseInt(p.getCodice());
                }
            }
            this.counter=i+1;
        }
        //storePacchetti();
        try {
            caricaPacchetti();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //storePortate();
        try {
            caricaPortate();
        } catch (FileNotFoundException e) {

        }
        //storeServizi();
        try {
            caricaServizi();
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        }
        //storePeriodiVariazione();
        try {
            caricaPeriodiVariazione();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            caricaServizioInCamera();
        } catch (FileNotFoundException e) {
            try {
                storeServizioInCamera();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        }

    }

    public void storeClienti() throws FileNotFoundException {
        FileOutputStream fos= null;
        fos = new FileOutputStream("clienti.txt");
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(fos);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            oos.writeObject(this.clienti);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void caricaClienti() throws FileNotFoundException {
        FileInputStream fis = new FileInputStream("clienti.txt");
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            this.clienti = (List<Cliente>) ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            ois.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void storeStanze() throws FileNotFoundException {
        /*this.stanze = new LinkedList<Stanza>();
        Stanza s1=new Stanza("1","Singola",50.0f,true);
        this.stanze.add(s1);
        Stanza s2=new Stanza("2","Singola",50.0f,true);
        this.stanze.add(s2);
        Stanza s3=new Stanza("3","Singola",50.0f,true);
        this.stanze.add(s3);
        Stanza s4=new Stanza("4","Singola",50.0f,true);
        this.stanze.add(s4);
        Stanza s5=new Stanza("5","Singola",50.0f,true);
        this.stanze.add(s5);
        Stanza s6=new Stanza("6","Matrimoniale",75.0f,true);
        this.stanze.add(s6);
        Stanza s7=new Stanza("7","Matrimoniale",75.0f,true);
        this.stanze.add(s7);
        Stanza s8=new Stanza("8","Matrimoniale",75.0f,true);
        this.stanze.add(s8);
        Stanza s9=new Stanza("9","Matrimoniale",75.0f,true);
        this.stanze.add(s9);
        Stanza s10=new Stanza("10","Suite",100.0f,true);
        this.stanze.add(s10);
        Stanza s11=new Stanza("11","Suite",100.0f,true);
        this.stanze.add(s11);*/

        FileOutputStream fos= null;
        fos = new FileOutputStream("stanze.txt");
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(fos);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            oos.writeObject(this.stanze);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void caricaStanze() throws FileNotFoundException {
        FileInputStream fis = new FileInputStream("stanze.txt");
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            this.stanze = (List<Stanza>) ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            ois.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void storePacchetti() throws FileNotFoundException {
        /*Pacchetto p1 = new Pacchetto("1", "mezza pensione", 10.0f);
        this.pacchetti.add(p1);
        Pacchetto p2 = new Pacchetto("2", "pensione completa", 15.0f);
        this.pacchetti.add(p2);
        Pacchetto p3 = new Pacchetto("3", "lusso", 25.0f);
        this.pacchetti.add(p3);*/
        FileOutputStream fos= null;
        fos = new FileOutputStream("pacchetti.txt");
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(fos);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            oos.writeObject(this.pacchetti);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void caricaPacchetti() throws FileNotFoundException {

        FileInputStream fis = new FileInputStream("pacchetti.txt");
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            this.pacchetti = (List<Pacchetto>) ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            ois.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void storePortate() throws FileNotFoundException {
        /*Portata p1 = new Portata("arancino", 5.5f);
        this.portate.add(p1);
        Portata p2 = new Portata("arancina",  1.5f);
        this.portate.add(p2);
        Portata p3 = new Portata("pizza", 8.5f);
        this.portate.add(p3);*/
        FileOutputStream fos= null;
        fos = new FileOutputStream("portate.txt");
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(fos);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            oos.writeObject(this.portate);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void caricaPortate() throws FileNotFoundException {
        FileInputStream fis = new FileInputStream("portate.txt");
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            this.portate = (List<Portata>) ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            ois.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void storeServizi() {
        Servizio s1 = new Servizio("Spa", 10.0f);
        this.servizi.add(s1);
        Servizio s2 = new Servizio("Palestra", 15.0f);
        this.servizi.add(s2);
        FileOutputStream fos= null;
        try {
            fos = new FileOutputStream("servizi.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(fos);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            oos.writeObject(this.servizi);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void caricaServizi() throws FileNotFoundException {
        FileInputStream fis = new FileInputStream("servizi.txt");
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            this.servizi = (List<Servizio>) ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            ois.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void storePeriodiVariazione() throws FileNotFoundException {
        /*PeriodoVariazione p1 = new PeriodoVariazione(Date.valueOf("2022-03-24"), Date.valueOf("2022-03-29"), 0.3f);
        this.periodiVariazione.add(p1);
        PeriodoVariazione p2 = new PeriodoVariazione(Date.valueOf("2022-04-12"), Date.valueOf("2022-04-19"), 0.3f);
        this.periodiVariazione.add(p2);*/
        FileOutputStream fos= null;
        fos = new FileOutputStream("periodovariazioni.txt");
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(fos);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            oos.writeObject(this.periodiVariazione);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void caricaPeriodiVariazione() throws FileNotFoundException {
        FileInputStream fis = new FileInputStream("periodovariazioni.txt");
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            this.periodiVariazione = (List<PeriodoVariazione>) ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            ois.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void storePrenotazioni() throws FileNotFoundException {
        FileOutputStream fos= null;
        fos = new FileOutputStream("prenotazioni.txt");
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(fos);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            oos.writeObject(this.prenotazioni);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void caricaPrenotazioni() throws FileNotFoundException {
        FileInputStream fis = new FileInputStream("prenotazioni.txt");
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            this.prenotazioni = (List<Prenotazione>) ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            ois.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void storeServizioInCamera() throws FileNotFoundException {
        FileOutputStream fos= null;
        fos = new FileOutputStream("servizicamera.txt");
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(fos);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            oos.writeObject(this.serviziInCamera);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void caricaServizioInCamera() throws FileNotFoundException {
        FileInputStream fis = new FileInputStream("servizicamera.txt");
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            this.serviziInCamera = (List<ServizioInCamera>) ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            ois.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<PeriodoVariazione> getPeriodiVariazione(){
        return this.periodiVariazione;
    }
    public Prenotazione getPrenotazioneInCorso() {
        return this.prenotazioneInCorso;
    }

    public void setPrenotazioneInCorso(Prenotazione p) {
        this.prenotazioneInCorso = p;
    }

    public List<Portata> getPortate() {
        return this.portate;
    }

    public List<Cliente> getClienti() {
        return clienti;
    }


    public List<Stanza> visualizzaStanze(String tipologia, Date data_inizio, Date data_fine) {
        List<Stanza> tipologiaStanze = new LinkedList<Stanza>();
        List<Stanza> stanzeDisponibili = new LinkedList<Stanza>();
        for (Stanza s : this.stanze) {
            if (tipologia.equalsIgnoreCase(s.getTipologia()) && s.getDisponibile()) {
                tipologiaStanze.add(s);
            }
        }
        for (Stanza s : tipologiaStanze) {
            if (this.prenotazioni.isEmpty()) {
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
            if (disponibile && !this.prenotazioni.isEmpty())
                stanzeDisponibili.add(s);
        }
        return stanzeDisponibili;
    }


    public boolean verificaStanzaPrenotata(String codiceStanza, Date data_inizio, Date data_fine) {
        boolean disponibile = true;
        if (this.prenotazioni.isEmpty())
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
    }

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
                this.prenotazioneInCorso.setCliente(c);
                break;
            }
        }
        if (!disponibile) {
            Cliente c = new Cliente(codice_fiscale, nome, cognome, numero_telefono, email, numero_carta);
            this.clienti.add(c);
            this.prenotazioneInCorso.setCliente(c);
        }
    }


    public void registraPrenotazione() {
        if (this.prenotazioneInCorso != null && this.prenotazioneInCorso.getCliente() != null && this.prenotazioneInCorso.getPacchetto() != null) {
            this.prenotazioneInCorso.getStatoprenotazione().gestioneStatoPrenotazione(this.prenotazioneInCorso,"Creato");
            this.prenotazioni.add(this.prenotazioneInCorso);
            this.counter = this.counter + 1;
        }
    } //verificare funzionamento e modificare SD ed eliminare metodo clone e addPrenotazione


    public List<Prenotazione> visualizzaPrenotazioni() {
        return this.prenotazioni;
    }

    public List<Cliente> visualizzaClienti() {
        return this.clienti;
    }

    public void annullaPrenotazioneInCorso() {
        this.prenotazioneInCorso = null;
    }

    public List<Prenotazione> mostraPrenotazioneCliente(String CodiceCliente) {
        List<Prenotazione> prenotazioniCliente = new LinkedList<Prenotazione>();
        for (Prenotazione p : this.prenotazioni) {
            if (p.getCliente().getCodice_fiscale().equalsIgnoreCase(CodiceCliente))
                prenotazioniCliente.add(p);
        }
        return prenotazioniCliente;
    }

    public List<Portata> mostraPortate() {
        List<Portata> portatedisponibili = new LinkedList<Portata>();
        for (Portata p : this.portate) {
            if (p.isDisponibilita())
                portatedisponibili.add(p);
        }
        return portatedisponibili;
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


    public void creaServizioInCamera(String codCamera, Date data) {
        for (Stanza s : this.getStanze()) {
            if (codCamera.equalsIgnoreCase(s.getCodice())) {
                this.servizioInCameraInCorso = new ServizioInCamera(data, s);
                break;
            }
        }
    }

    public void registraPortate(String nome, int quantita) {
        for (Portata p : this.mostraPortate()) {
            if (nome.equalsIgnoreCase(p.getNome())) {
                this.getServizioInCameraInCorso().registraPortata(p, quantita);
                break;
            }
        }
    }

    public void registraServizioInCamera() {

        this.serviziInCamera.add(this.servizioInCameraInCorso);

    }

    public List<ServizioInCamera> getServiziInCamera() {
        return serviziInCamera;
    }

    public void resettaServizioInCameraInCorso() {
        this.servizioInCameraInCorso = null;
    }

    public List<Servizio> getServizi() {
        return servizi;
    }

    public List<Stanza> mostraStanzeNonPrenotate(Date data_inizio, Date data_fine) {
        List<Stanza> stanzeDisponibili = new LinkedList<Stanza>();
        for (Stanza s : this.stanze) {
            if (s.getDisponibile() == true) {
                if (this.prenotazioni.isEmpty()) {
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
                if (disponibile && !this.prenotazioni.isEmpty())
                    stanzeDisponibili.add(s);
            }
        }
        return stanzeDisponibili;
    }

    public void modificaStanza(String codiceStanza, boolean stato) {
        Iterator i = this.getStanze().iterator();
        while (i.hasNext()) {
            Stanza s = (Stanza) i.next();
            if (s.getCodice().equals(codiceStanza)) {
                i.remove();
                s.setDisponibile(stato);
                this.stanze.add(s);
                break;
            }
        }
    }

    public  Stanza getStanza(String codice){
        Iterator i = this.getStanze().iterator();
        while (i.hasNext()) {
            Stanza s = (Stanza) i.next();
            if (s.getCodice().equals(codice)) {
                return s;
            }
        }
        return  null;
    }

    public List<Stanza> mostraStanzeDisabilitate(){
        List<Stanza> stanzeDisabilitate = new LinkedList<Stanza>();
        for(Stanza s : this.stanze){
            if(!s.getDisponibile())
                stanzeDisabilitate.add(s);
        }
        return stanzeDisabilitate;
    }

    public void aggiungiPeriodoVariazione(Date dataI, Date dataF, float variazione){
        boolean trovato=true;
        if(this.getPeriodiVariazione().isEmpty())
            trovato=true;
        else {
            for (PeriodoVariazione pv : this.getPeriodiVariazione()) {
                if (!pv.isDisponibile(dataI, dataF)) {
                    trovato = false;
                }
            }
        }

        if(trovato) {
            PeriodoVariazione pv=new PeriodoVariazione(dataI,dataF,variazione);
            this.periodiVariazione.add(pv);
            System.out.println("Periodo variazione aggiunto");
        }else
            System.out.println("Periodo variazione già presente o non valido");
    }

    public void inserisciPortata(String nome, float prezzo){
        Portata p = new Portata(nome, prezzo);
        this.portate.add(p);
        System.out.println("Portata aggiunta nel menù");
    }

    public Portata cercaPortata(String nome){
        Iterator i = this.getPortate().iterator();
        while (i.hasNext()) {
            Portata p = (Portata) i.next();
            if (p.getNome().equals(nome)) {
                return p;
            }
        }
        return null;
    }
    public void modificaPortata(String nome, boolean stato){
        Iterator i = this.getPortate().iterator();
        while (i.hasNext()) {
            Portata p = (Portata) i.next();
            if (p.getNome().equals(nome)) {
                i.remove();
                p.setDisponibilita(stato);
                this.portate.add(p);
                break;
            }
        }
    }

    public String getCounterPacchetto(){
        String c = "0";
        for(Pacchetto p : this.visualizzaPacchetto()){
            if(c.compareTo(p.getCodice()) < 0){
                c = p.getCodice();
            }
        }
        int n = Integer.parseInt(c);
        n++;
        return Integer.toString(n);
    }


    public float calcolaConto(Prenotazione p){
        int giorniVariazione = 0;
        int dataI = (int) ((p.getData_inizio().getTime())/(86400000))%365;
        int dataF = (int) ((p.getData_fine().getTime())/(86400000))%365;
        int giorniTotali= (dataF - dataI) + 1;
        float variazione = 0;
        float prezzo_stanza = 0;
        float conto = 0;
        float prezzo_servizi= 0;
        float prezzo_pacchetto=0;
        float conto_servizio_camera=0;

        VariazioneStrategyFactory fs = VariazioneStrategyFactory.getInstance();
        VariazioneStrategyInterface st = fs.getVariazioneStrategy();
        variazione=st.applicaVariazione(this.periodiVariazione,p.getData_inizio(),p.getData_fine());
        System.out.println("V:"+variazione);
        prezzo_stanza = (p.getStanza().getPrezzo()*variazione)+p.getStanza().getPrezzo()*giorniTotali;
        prezzo_pacchetto=(p.getPacchetto().getPrezzo()*variazione)+p.getPacchetto().getPrezzo()*giorniTotali;

        for(RichiestaDiServizio rc: p.getRichiesteServizi()){
            prezzo_servizi=prezzo_servizi+rc.getSubTotale();
        }
        for(ServizioInCamera sc: this.serviziInCamera){
            if(sc.getStanza().getCodice().equals(p.getStanza().getCodice())){
                if(p.getData_inizio().equals(sc.getData()) ||
                   p.getData_fine().equals(sc.getData()) ||
                        (p.getData_inizio().before(sc.getData()) && p.getData_fine().after(sc.getData()))){
                  conto_servizio_camera = conto_servizio_camera + sc.getOrdineInCorso().getSubTotale();
                }
            }
        }
        if(p.getPacchetto().getNome().equalsIgnoreCase("lusso")){
            conto_servizio_camera = conto_servizio_camera - (conto_servizio_camera * 0.2f);
        }
        conto = prezzo_pacchetto+prezzo_stanza+conto_servizio_camera+prezzo_servizi;
        return Math.abs(conto);
    }

}
