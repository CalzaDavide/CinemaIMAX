package Data_tier;

public class Moderatore {
    int id;
    String email;
    String password;
    String nome;
    String cognome;
    boolean isAdmin = false;

    public void setId(int id) {
        this.id = id;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getCognome() {
        return cognome;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getPassword() {
        return password;
    }

    public void modificaEmail(String email) {
        this.email = email;
    }

    public void modificaPassword(String password) {
        this.password = password;
    }
}
