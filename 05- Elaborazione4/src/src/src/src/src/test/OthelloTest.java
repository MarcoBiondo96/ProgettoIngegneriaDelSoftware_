package test;
import dominio.Othello;
import dominio.Stanza;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.testng.annotations.BeforeTest;

import java.io.FileNotFoundException;
import java.sql.Date;
import static org.junit.Assert.*;
public class OthelloTest {

    static Othello othello;
    @BeforeClass
    public static void initTest() {
        othello = Othello.getInstance();
    }


    @Test
    public void TestInserimentoStanzaPrenotazioneInCorso() throws FileNotFoundException {
        //othello.caricaStanze();
        othello.registraStanze("1");
        assertNotNull(othello.getPrenotazioneInCorso());
        System.out.println("Prenotazione in corso:"+othello.getPrenotazioneInCorso().getStanza());
    }

    @Test
    public void TestInserimentoPacchettoPrenotazioneInCorso() throws FileNotFoundException {
        othello.caricaStanze();
        othello.caricaPacchetti();
        othello.registraStanze("1");
        othello.registraPacchetto("1");
        assertNotNull(othello.getPrenotazioneInCorso());
    }
    @Test
    public void TestInserimentoClientePrenotazioneInCorso() throws FileNotFoundException {
        othello.caricaStanze();
        othello.caricaPacchetti();
        othello.registraStanze("1");
        othello.registraPacchetto("1");
        othello.registraCliente("Marco", "Vaiana", "MV", "marcovaiana@gmail.com", "38976453", "3373383883");
        assertNotNull(othello.getPrenotazioneInCorso());
    }

    @Test
    public void TestInserimentoPrenotazioneInCorso() throws FileNotFoundException {
        othello.caricaStanze();
        othello.caricaPacchetti();
        othello.registraStanze("1");
        othello.registraPacchetto("1");
        othello.registraCliente("Marco", "Vaiana", "MV", "marcovaiana@gmail.com", "38976453", "3373383883");
        othello.getPrenotazioneInCorso().setData_fine(Date.valueOf("2022-04-10"));
        othello.getPrenotazioneInCorso().setData_inizio(Date.valueOf("2022-03-25"));
        othello.registraPrenotazione();
        assertNotNull(othello.getPrenotazioneInCorso());
    }


    @Test
    public void TestCreaNuovoServizioInCamera(){
        try {
            othello.caricaStanze();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        othello.registraStanze("1");
        othello.registraPacchetto("1");
        othello.registraCliente("Marco", "Vaiana", "MV", "marcovaiana@gmail.com", "38976453", "3373383883");
        othello.getPrenotazioneInCorso().setData_fine(Date.valueOf("2022-04-10"));
        othello.getPrenotazioneInCorso().setData_inizio(Date.valueOf("2022-03-25"));
        othello.registraPrenotazione();
        assertNotNull(othello.getPrenotazioneInCorso());
        othello.creaServizioInCamera("1", Date.valueOf("2022-03-30"));
        assertNotNull(othello.getServizioInCameraInCorso());
    }

    @Test
    public void TestRegistraPortate() throws FileNotFoundException {
        othello.caricaStanze();
        othello.caricaPortate();
        othello.registraStanze("1");
        othello.registraPacchetto("1");
        othello.registraCliente("Marco", "Vaiana", "MV", "marcovaiana@gmail.com", "38976453", "3373383883");
        othello.getPrenotazioneInCorso().setData_fine(Date.valueOf("2022-04-10"));
        othello.getPrenotazioneInCorso().setData_inizio(Date.valueOf("2022-03-25"));
        othello.registraPrenotazione();
        assertNotNull(othello.getPrenotazioneInCorso());
        othello.creaServizioInCamera("1", Date.valueOf("2022-03-30"));
        assertNotNull(othello.getServizioInCameraInCorso());
        othello.registraPortate("arancino", 1);
    }

    @Test
    public void TestRegistraServizioInCamera() throws FileNotFoundException {
        othello.caricaStanze();
        othello.caricaPortate();
        othello.registraStanze("1");
        othello.registraPacchetto("1");
        othello.registraCliente("Marco", "Vaiana", "MV", "marcovaiana@gmail.com", "38976453", "3373383883");
        othello.getPrenotazioneInCorso().setData_fine(Date.valueOf("2022-04-10"));
        othello.getPrenotazioneInCorso().setData_inizio(Date.valueOf("2022-03-25"));
        othello.registraPrenotazione();
        assertNotNull(othello.getPrenotazioneInCorso());
        othello.creaServizioInCamera("1", Date.valueOf("2022-03-30"));
        assertNotNull(othello.getServizioInCameraInCorso());
        othello.registraPortate("arancino", 1);
        othello.registraServizioInCamera();
    }

    @Test
    public void TestPeriodoVariazioni(){
        System.out.println(othello.getPeriodiVariazione().toString());
        int expected = othello.getPeriodiVariazione().size();
        othello.aggiungiPeriodoVariazione(Date.valueOf("2023-12-06"),Date.valueOf("2023-12-25"),0.1f);
        expected++;
        assertEquals("Data valida",expected,othello.getPeriodiVariazione().size());
        othello.aggiungiPeriodoVariazione(Date.valueOf("2023-12-06"),Date.valueOf("2023-12-04"),0.1f);
        expected++;
        assertNotEquals("Data non valida",expected,othello.getPeriodiVariazione().size());

    }

    @Test
    public void TestModificaDisponibilitàStanza(){
        Stanza s=new Stanza("48","Singola",78.0f,true);
        othello.getStanze().add(s);
        othello.modificaStanza("48",false);
        assertEquals("Variazione effettuata stanza diventata non disponibile",false,othello.getStanza("48").getDisponibile());
        othello.modificaStanza("48",true);
        assertEquals("Variazione effettuata stanza diventata disponibile",true,othello.getStanza("48").getDisponibile());
    }

    @Test
    public void TestInserisciPortate(){
        int expected= othello.getPortate().size();
        othello.inserisciPortata("Diavola",1.5f);
        expected++;
        assertEquals("Aggiunta di portata",expected,othello.getPortate().size());
    }

    @Test
    public void TestModificaDisponibilitàPortata(){
        othello.inserisciPortata("Diavola",1.5f);
        assertEquals("Portata Disponibile",true,othello.cercaPortata("Diavola").isDisponibilita());
        othello.modificaPortata("Diavola",false);
        assertEquals("Portata Non Disponibile",false,othello.cercaPortata("Diavola").isDisponibilita());
        othello.modificaPortata("Diavola",true);
        assertEquals("Portata Nuovamente Disponibile",true,othello.cercaPortata("Diavola").isDisponibilita());
    }




}

