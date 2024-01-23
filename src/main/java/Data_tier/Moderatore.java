package Data_tier;

public class Moderatore {
    // Attributi del Moderatore
    private int id;             // Identificativo unico del Moderatore
    private String email;       // Indirizzo email del Moderatore
    private String password;    // Password del Moderatore
    private String nome;        // Nome del Moderatore
    private String cognome;     // Cognome del Moderatore

    private boolean isAdmin;    // Flag che indica se il Moderatore ha privilegi di amministratore


    // Metodo getter per verificare se il Moderatore è un amministratore
    public boolean isAdmin() {
        return isAdmin;
    }

    // Metodo setter per impostare i privilegi di amministratore del Moderatore
    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    // Metodo setter per impostare l'identificativo unico del Moderatore
    public void setId(int id) {
        this.id = id;
    }

    // Metodo setter per impostare il cognome del Moderatore
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    // Metodo setter per impostare l'indirizzo email del Moderatore
    public void setEmail(String email) {
        this.email = email;
    }

    // Metodo setter per impostare il nome del Moderatore
    public void setNome(String nome) {
        this.nome = nome;
    }


    // Metodo setter per impostare la password del Moderatore
    public void setPassword(String password) {
        this.password = password;
    }

    // Metodo getter per recuperare l'identificativo unico del Moderatore
    public int getId() {
        return id;
    }

    // Metodo getter per recuperare il cognome del Moderatore
    public String getCognome() {
        return cognome;
    }

    // Metodo getter per recuperare l'indirizzo email del Moderatore
    public String getEmail() {
        return email;
    }

    // Metodo getter per recuperare il nome del Moderatore
    public String getNome() {
        return nome;
    }

    // Metodo getter per recuperare la password del Moderatore
    public String getPassword() {
        return password;
    }

    // Metodo per modificare l'indirizzo email del Moderatore
    public void modificaEmail(String email) {
        this.email = email;
    }

    // Metodo per modificare la password del Moderatore
    public void modificaPassword(String password) {
        this.password = password;
    }
}
