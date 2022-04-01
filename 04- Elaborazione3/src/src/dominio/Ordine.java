package dominio;

import java.util.LinkedList;
import java.util.List;

public class Ordine {

    private List<QuantitaPortata> quantitaPortate;
    private float subTotale;

    public Ordine() {
        this.quantitaPortate = new LinkedList<QuantitaPortata>();
    }

    public List<QuantitaPortata> getQuantitaPortate() {
        return quantitaPortate;
    }



    public void setQuantitaPortata(Portata p,int q){
        QuantitaPortata qp= new QuantitaPortata(p,q);
        this.quantitaPortate.add(qp);
    }

    public float getSubTotale() {
        return subTotale;
    }

    public void setSubTotale(float sub) {
        subTotale = sub;
    }



}
