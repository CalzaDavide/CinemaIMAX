package Data_tier;

public class Gestore {
    int id;
    String email;
    String password;
    String nome;
    String cognome;

    boolean isAdmin = false;

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
