package Data_tier;

import java.util.GregorianCalendar;

public class Proiezione {

    int id;
    GregorianCalendar data_ora;
    Film film;
    int posti;
    Sala sala;

    public void setData_ora(GregorianCalendar data_ora) {
        this.data_ora = data_ora;
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

    public GregorianCalendar getData_ora() {
        return data_ora;
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
