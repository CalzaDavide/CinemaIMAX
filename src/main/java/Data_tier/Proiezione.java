package Data_tier;

import java.sql.Date;
import java.sql.Time;
import java.util.GregorianCalendar;

public class Proiezione {

    int id;
    Date data;
    Time orario;
    Film film;
    int posti;
    Sala sala;

    public void setData(Date data) {
        this.data = data;
    }

    public void setOrario(Time orario) {
        this.orario = orario;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public void setPosti(int posti) {
        this.posti = posti;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public Time getOrario() {
        return orario;
    }

    public Film getFilm() {
        return film;
    }

    public int getPosti() {
        return posti;
    }

    public Sala getSala() {
        return sala;
    }

    /*public void modifica(GregorianCalendar data_ora, Film film, int posti, Sala sala){
        this.data_ora = data_ora;
        this.posti = posti;
        this.sala = sala;
        this.film = film;
    }*/
}
