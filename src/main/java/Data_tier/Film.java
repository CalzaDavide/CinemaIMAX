package Data_tier;

import java.util.ArrayList;

public class Film {
    int id;
    String titolo;
    String descrizione;
    ArrayList<String> attori;
    int durata;
    String genere;

    public int getId() {
        return id;
    }

    public String getTitolo() {
        return titolo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public ArrayList<String> getAttori() {
        return attori;
    }

    public int getDurata() {
        return durata;
    }

    public String getGenere() {
        return genere;
    }

    public void modifica(String titolo,String descrizione,ArrayList<String> attori,String genere,int durata){
        this.titolo = titolo;
        this.descrizione = descrizione;
        this.attori = attori;
        this.genere = genere;
        this.durata = durata;
    }
}
