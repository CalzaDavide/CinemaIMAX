package Data_tier;

public class Film {
    private int id; // id del film
    private String titolo; // Titolo del film
    private String descrizione; // Descrizione del film
    private String attori; // Attori del film
    private int durata; // Durata del film
    private String generi; // Generi del film
    private String regista; // Regista del film


    private String locandina; // Path della locandina del film

    public void setId(int id) {
        this.id = id;
    } // set dell'id


    public void setAttori(String attori) {
        this.attori = attori;
    } //set degli attori

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    } // set della descrizone

    public void setDurata(int durata) {
        this.durata = durata;
    } // set della durata

    public void setGeneri(String generi) {
        this.generi = generi;
    } // set dei generi

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    } // set del titolo

    public int getId() {
        return id;
    } // get dell'id

    public void setLocandina(String locandina) {
        this.locandina = locandina;
    } // get del path della locandina

    public String getTitolo() {
        return titolo;
    } // get del titolo

    public String getDescrizione() {
        return descrizione;
    } // get della descrizione

    public String getAttori() {
        return attori;
    } // get del/degli attori

    public String getLocandina() {
        return locandina;
    } // get del path della locandina

    public int getDurata() {
        return durata;
    } // get della durata del film

    public String getGeneri() {
        return generi;
    } // get del/dei generi

    public void setRegista(String regista) {
        this.regista = regista;
    } //set del regista

    public String getRegista() {
        return regista;
    } // get del regista
}
