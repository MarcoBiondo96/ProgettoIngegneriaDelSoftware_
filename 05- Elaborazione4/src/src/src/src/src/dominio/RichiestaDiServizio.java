package dominio;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class RichiestaDiServizio implements Serializable {

    private Date data_inizio;
    private Date data_fine;
    private float subTotale;
    private List<Servizio> servizi;

    public RichiestaDiServizio(Date data_inizio, Date data_fine) {
        this.data_inizio = data_inizio;
        this.data_fine = data_fine;
        this.servizi = new LinkedList<Servizio>();
        this.subTotale=0;
    }

    public Date getData_inizio() {
        return this.data_inizio;
    }

    public void setData_inizio(Date data_inizio) {
        this.data_inizio = data_inizio;
    }

    public Date getData_fine() {
        return this.data_fine;
    }

    public void setData_fine(Date data_fine) {
        this.data_fine = data_fine;
    }

    public float getSubTotale() {
        return subTotale;
    }

    public void setServizio(Servizio s){
        int dataI = (int) ((this.data_inizio.getTime())/(86400000))%365;
        int dataF = (int) ((this.data_fine.getTime())/(86400000))%365;
        int giorniTotali= (dataF - dataI) + 1;
        this.servizi.add(s);
        this.setSubTotale(this.getSubTotale()+s.getPrezzo()*giorniTotali);
    }
    public void setSubTotale(float subTotale) {
        this.subTotale = subTotale;
    }

    public List<Servizio> getServizi() {
        return this.servizi;
    }
}
