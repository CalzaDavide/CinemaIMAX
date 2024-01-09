package Data_tier;

import java.util.GregorianCalendar;

public class Proiezione {

    int id;
    GregorianCalendar data_ora;
    float costo;
    Film film;
    int posti;
    Sala sala;

    public int getId() {
        return id;
    }

    public GregorianCalendar getData_ora() {
        return data_ora;
    }

    public float getCosto() {
        return costo;
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

    public void modifica(GregorianCalendar data_ora, float costo, Film film, int posti, Sala sala){
        this.data_ora = data_ora;
        this.costo = costo;
        this.posti = posti;
        this.sala = sala;
        this.film = film;
    }
}
