package interfaccia;

import dominio.PeriodoVariazione;

import java.util.Date;
import java.util.List;

public class VariazioneStandardStrategy implements VariazioneStrategyInterface {
    @Override
    public float applicaVariazione(List<PeriodoVariazione> pv, Date data_inizio, Date data_fine){
        float variazione=0.0f;
        for(PeriodoVariazione p : pv) {
            if(p.calcolaGiorniVariazione(data_inizio, data_fine)!=0)
                variazione=variazione+ p.calcolaGiorniVariazione(data_inizio, data_fine)*p.getVariazione();

        }

        return variazione;
    }
}
