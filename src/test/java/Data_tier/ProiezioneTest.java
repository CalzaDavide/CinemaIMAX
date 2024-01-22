package Data_tier;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.sql.Time;

public class ProiezioneTest {

    @Test
    public void testSetData() {
        Proiezione proiezione = new Proiezione();
        Date data = new Date(2022, 1, 1);
        proiezione.setData(data);
        assertEquals(data, proiezione.getData());
    }

    @Test
    public void testSetOrario() {
        Proiezione proiezione = new Proiezione();
        Time orario = new Time(12, 0, 0);
        proiezione.setOrario(orario);
        assertEquals(orario, proiezione.getOrario());
    }

    @Test
    public void testSetFilm() {
        Proiezione proiezione = new Proiezione();
        Film film = new Film();
        proiezione.setFilm(film);
        assertEquals(film, proiezione.getFilm());
    }

    @Test
    public void testSetPosti() {
        Proiezione proiezione = new Proiezione();
        int posti = 100;
        proiezione.setPosti(posti);
        assertEquals(posti, proiezione.getPosti());
    }

    @Test
    public void testSetSala() {
        Proiezione proiezione = new Proiezione();
        Sala sala = new Sala();
        proiezione.setSala(sala);
        assertEquals(sala, proiezione.getSala());
    }

    @Test
    public void testGetId() {
        Proiezione proiezione = new Proiezione();
        proiezione.setId(1);
        assertEquals(1, proiezione.getId());
    }

    @Test
    public void testGetData() {
        Proiezione proiezione = new Proiezione();
        Date data = new Date(2022, 1, 1);
        proiezione.setData(data);
        assertEquals(data, proiezione.getData());
    }

    @Test
    public void testGetOrario() {
        Proiezione proiezione = new Proiezione();
        Time orario = new Time(12, 0, 0);
        proiezione.setOrario(orario);
        assertEquals(orario, proiezione.getOrario());
    }

    @Test
    public void testGetFilm() {
        Proiezione proiezione = new Proiezione();
        Film film = new Film();
        proiezione.setFilm(film);
        assertEquals(film, proiezione.getFilm());
    }

    @Test
    public void testGetPosti() {
        Proiezione proiezione = new Proiezione();
        int posti = 100;
        proiezione.setPosti(posti);
        assertEquals(posti, proiezione.getPosti());
    }

    @Test
    public void testGetSala() {
        Proiezione proiezione = new Proiezione();
        Sala sala = new Sala();
        proiezione.setSala(sala);
        assertEquals(sala, proiezione.getSala());
    }
}