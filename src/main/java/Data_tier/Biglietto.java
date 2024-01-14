package Data_tier;

public class Biglietto {
    int id;
    String nome;
    String cognome;
    int posto;
    Proiezione proiezione;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setPosto(int posto) {
        this.posto = posto;
    }

    public void setProiezione(Proiezione proiezione) {
        this.proiezione = proiezione;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public int getPosto() {
        return posto;
    }

    public Proiezione getProiezione() {
        return proiezione;
    }
}
