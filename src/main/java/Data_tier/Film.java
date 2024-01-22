package Data_tier;

public class Film {
    int id;
    String titolo;
    String descrizione;
    String attori;
    int durata;
    String generi;
    String regista;


    String locandina;

    public void setId(int id) {
        this.id = id;
    }


    public void setAttori(String attori) {
        this.attori = attori;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }

    public void setGeneri(String generi) {
        this.generi = generi;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getId() {
        return id;
    }

    public void setLocandina(String locandina) {
        this.locandina = locandina;
    }

    public String getTitolo() {
        return titolo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public String getAttori() {
        return attori;
    }

    public String getLocandina() {
        return locandina;
    }

    public int getDurata() {
        return durata;
    }

    public String getGeneri() {
        return generi;
    }

    public void setRegista(String regista) {
        this.regista = regista;
    }

    public String getRegista() {
        return regista;
    }
}
