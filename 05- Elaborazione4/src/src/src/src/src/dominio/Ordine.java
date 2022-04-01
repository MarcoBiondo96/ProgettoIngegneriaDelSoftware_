package dominio;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Ordine implements Serializable {

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
        if(this.subTotale!=0){
            subTotale=subTotale+p.getPrezzo()*q;
        }else
            subTotale=p.getPrezzo()*q;
    }

    public float getSubTotale() {
        return subTotale;
    }

    public void setSubTotale(float sub) {
        subTotale = sub;
    }



}
