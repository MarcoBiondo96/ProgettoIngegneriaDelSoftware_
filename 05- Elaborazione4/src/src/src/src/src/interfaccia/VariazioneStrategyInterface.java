package interfaccia;

import dominio.PeriodoVariazione;

import java.util.Date;
import java.util.List;

public interface VariazioneStrategyInterface {
    float applicaVariazione(List<PeriodoVariazione> pv, Date data_inizio, Date data_fine);
}
