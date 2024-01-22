package Data_tier;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FilmTest {

    @Test
    public void testSetAndGetId() {
        Film film = new Film();
        film.setId(1);
        int id = film.getId();
        Assertions.assertEquals(1, id);
    }

    @Test
    public void testSetAndGetAttori() {
        Film film = new Film();
        film.setAttori("Robert Downey Jr., Chris Evans");
        String attori = film.getAttori();
        Assertions.assertEquals("Robert Downey Jr., Chris Evans", attori);
    }

    @Test
    public void testSetAndGetDescrizione() {
        Film film = new Film();
        film.setDescrizione("Un film d'azione avvincente");
        String descrizione = film.getDescrizione();
        Assertions.assertEquals("Un film d'azione avvincente", descrizione);
    }

    @Test
    public void testSetAndGetDurata() {
        Film film = new Film();
        film.setDurata(120);
        int durata = film.getDurata();
        Assertions.assertEquals(120, durata);
    }

    @Test
    public void testSetAndGetGeneri() {
        Film film = new Film();
        film.setGeneri("Azione, Avventura");
        String generi = film.getGeneri();
        Assertions.assertEquals("Azione, Avventura", generi);
    }

    @Test
    public void testSetAndGetTitolo() {
        Film film = new Film();
        film.setTitolo("Avengers: Endgame");
        String titolo = film.getTitolo();
        Assertions.assertEquals("Avengers: Endgame", titolo);
    }

    @Test
    public void testSetAndGetLocandina() {
        Film film = new Film();
        film.setLocandina("avengers_endgame.jpg");
        String locandina = film.getLocandina();
        Assertions.assertEquals("avengers_endgame.jpg", locandina);
    }

    @Test
    public void testSetAndGetRegista() {
        Film film = new Film();
        film.setRegista("Anthony Russo, Joe Russo");
        String regista = film.getRegista();
        Assertions.assertEquals("Anthony Russo, Joe Russo", regista);
    }
}