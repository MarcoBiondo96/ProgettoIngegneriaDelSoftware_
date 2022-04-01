package test;

import dominio.Othello;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.*;

public class OthelloTest {

    static Othello othello;

    @BeforeClass
    public static void initTest() {
        othello = Othello.getInstance();
    }


    @Test
    public void TestInserimentoStanzaPrenotazioneInCorso(){
        othello.caricaStanze();
        othello.registraStanze("1");
        assertNotNull(othello.getPrenotazioneInCorso());
    }

    @Test
    public void TestInserimentoPacchettoPrenotazioneInCorso(){
        othello.caricaStanze();
        othello.caricaPacchetti();
        othello.registraStanze("1");
        othello.registraPacchetto("1");
        assertNotNull(othello.getPrenotazioneInCorso());
    }

    @Test
    public void TestInserimentoClientePrenotazioneInCorso(){
        othello.caricaStanze();
        othello.caricaPacchetti();
        othello.registraStanze("1");
        othello.registraPacchetto("1");
        othello.registraCliente("Marco", "Vaiana", "MV", "marcovaiana@gmail.com", "38976453", "3373383883");
        assertNotNull(othello.getPrenotazioneInCorso());
    }

    @Test
    public void TestInserimentoPrenotazioneInCorso(){
        othello.caricaStanze();
        othello.caricaPacchetti();
        othello.registraStanze("1");
        othello.registraPacchetto("1");
        othello.registraCliente("Marco", "Vaiana", "MV", "marcovaiana@gmail.com", "38976453", "3373383883");
        othello.registraPrenotazione(Date.valueOf("2022-03-11"), Date.valueOf("2022-03-14"));
        assertNotNull(othello.getPrenotazioneInCorso());
    }


    @Test
    public void TestCreaNuovoServizioInCamera(){
        othello.caricaStanze();
        othello.registraStanze("1");
        othello.registraPacchetto("1");
        othello.registraCliente("Marco", "Vaiana", "MV", "marcovaiana@gmail.com", "38976453", "3373383883");
        othello.registraPrenotazione(Date.valueOf("2022-03-25"), Date.valueOf("2022-04-10"));
        assertNotNull(othello.getPrenotazioneInCorso());
        othello.creaServizioInCamera("1", Date.valueOf("2022-03-30"));
        assertNotNull(othello.getServizioInCameraInCorso());
    }

    @Test
    public void TestRegistraPortate(){
        othello.caricaStanze();
        othello.caricaPortate();
        othello.registraStanze("1");
        othello.registraPacchetto("1");
        othello.registraCliente("Marco", "Vaiana", "MV", "marcovaiana@gmail.com", "38976453", "3373383883");
        othello.registraPrenotazione(Date.valueOf("2022-03-25"), Date.valueOf("2022-04-10"));
        assertNotNull(othello.getPrenotazioneInCorso());
        othello.creaServizioInCamera("1", Date.valueOf("2022-03-30"));
        assertNotNull(othello.getServizioInCameraInCorso());
        othello.registraPortate("arancino", 1);
    }

    @Test
    public void TestRegistraServizioInCamera(){
        othello.caricaStanze();
        othello.caricaPortate();
        othello.registraStanze("1");
        othello.registraPacchetto("1");
        othello.registraCliente("Marco", "Vaiana", "MV", "marcovaiana@gmail.com", "38976453", "3373383883");
        othello.registraPrenotazione(Date.valueOf("2022-03-25"), Date.valueOf("2022-04-10"));
        assertNotNull(othello.getPrenotazioneInCorso());
        othello.creaServizioInCamera("1", Date.valueOf("2022-03-30"));
        assertNotNull(othello.getServizioInCameraInCorso());
        othello.registraPortate("arancino", 1);
        othello.registraServizioInCamera();
    }


}