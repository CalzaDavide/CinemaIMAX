package Data_tier;

import java.sql.Date;
import java.sql.Time;

// Classe che rappresenta una proiezione nel livello dei dati
public class Proiezione {

    private int id;             // Identificativo unico della proiezione
    private Date data;          // Data della proiezione
    private Time orario;        // Orario della proiezione
    Film film;                  // Oggetto Film associato alla proiezione
    private int posti;          // Numero di posti disponibili per la proiezione
    Sala sala;                  // Oggetto Sala associato alla proiezione


    // Metodo setter per impostare la data della proiezione
    public void setData(Date data) {
        this.data = data;
    }

    // Metodo setter per impostare l'orario della proiezione
    public void setOrario(Time orario) {
        this.orario = orario;
    }

    // Metodo setter per impostare il film associato alla proiezione
    public void setFilm(Film film) {
        this.film = film;
    }

    // Metodo setter per impostare il numero di posti disponibili per la proiezione
    public void setPosti(int posti) {
        this.posti = posti;
    }

    // Metodo setter per impostare la sala associata alla proiezione
    public void setSala(Sala sala) {
        this.sala = sala;
    }

    // Metodo getter per recuperare l'identificativo unico della proiezione
    public int getId() {
        return id;
    }

    // Metodo setter per impostare l'identificativo unico della proiezione
    public void setId(int id) {
        this.id = id;
    }

    // Metodo getter per recuperare la data della proiezione
    public Date getData() {
        return data;
    }

    // Metodo getter per recuperare l'orario della proiezione
    public Time getOrario() {
        return orario;
    }

    // Metodo getter per recuperare il film associato alla proiezione
    public Film getFilm() {
        return film;
    }

    // Metodo getter per recuperare il numero di posti disponibili per la proiezione
    public int getPosti() {
        return posti;
    }

    // Metodo getter per recuperare la sala associata alla proiezione
    public Sala getSala() {
        return sala;
    }
}
