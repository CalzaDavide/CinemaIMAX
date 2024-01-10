package model;

public class Admin {


    private String nome;
    private  String cognome;
    private  String passw;
    private  String email;
    private final int id;
    public Admin(int id, String nome,String cognome, String passw, String email){
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.passw = passw;
        this.email = email;
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

    public String getPassw() {
        return passw;
    }

    public void setNome(String nom){
        nome = nom;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setPassw(String passw) {
        this.passw = passw;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
