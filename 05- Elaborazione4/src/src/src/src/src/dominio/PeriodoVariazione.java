package dominio;

import java.io.Serializable;
import java.util.Date;

public class PeriodoVariazione implements Serializable {

    private Date data_inizio;
    private Date data_fine;
    private float variazione;

    public PeriodoVariazione(Date data_inizio, Date data_fine, float variazione) {
        this.data_inizio = data_inizio;
        this.data_fine = data_fine;
        this.variazione = variazione;
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

    public float getVariazione() {
        return this.variazione;
    }

    public void setVariazione(float variazione) {
        this.variazione = variazione;
    }

    public int calcolaGiorniVariazione(Date dataInizio, Date dataFine){
        if(dataInizio.equals(data_inizio) && dataFine.equals(data_fine)){
            long diff = ((dataFine.getTime() - dataInizio.getTime())/86400000)%365 + 1;
            return (int) diff;
        }
        if(dataInizio.after(data_inizio) && dataFine.after(data_fine) && dataInizio.before(data_fine)){
            long varF = ((dataFine.getTime() - data_fine.getTime())/86400000)%365 + 1;
            long diffGiorni = ((dataFine.getTime() - dataInizio.getTime())/86400000)%365 + 1;
            return (int) (diffGiorni - varF);
        }
        if(dataInizio.before(data_inizio) && dataFine.before(data_fine) && (dataFine.after(data_inizio))){
            long varI = ((dataInizio.getTime() - data_inizio.getTime())/86400000)%365 + 1;
            long varF = ((dataFine.getTime() - data_fine.getTime())/86400000)%365 + 1;
            long diffGiorni = ((dataFine.getTime() - dataInizio.getTime())/86400000)%365 + 1;
            return  (int) (diffGiorni + varI + varF);
        }
        if(dataInizio.before(data_inizio) && dataFine.after(data_fine)){
            long diffGiorniVar = ((data_fine.getTime() - data_inizio.getTime())/86400000)%365 + 1;
            return (int) diffGiorniVar;
        }
        if(dataInizio.equals(data_inizio) && dataFine.before(data_fine)){
            long diffGiorni = ((dataFine.getTime() - dataInizio.getTime())/86400000)%365;
            return (int) (diffGiorni + 1);
        }
        if(dataInizio.equals(data_inizio) && dataFine.after(data_fine)){
            long var = ((data_fine.getTime() - data_inizio.getTime())/86400000)%365;
            return (int) (var + 1);
        }
        if(dataInizio.before(data_inizio) && dataFine.equals(data_fine)){
            long varI = ((data_fine.getTime() - data_inizio.getTime())/86400000)%365;
            return (int) (varI + 1);
        }
        if(dataInizio.after(data_inizio) && dataFine.equals(data_fine)){
            long varF = ((dataFine.getTime() - dataFine.getTime())/86400000)%365;
            return (int) (varF + 1);
        }
        return 0;
    }
    public boolean isDisponibile( Date dataInizio, Date dataFine) {
        if(dataInizio.after(dataFine)){
            return false;
        }
        if(dataInizio.equals(dataFine)){
            return false;
        }
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

        return true;
    }

}
