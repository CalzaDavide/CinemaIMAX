package Data_tier;

// Classe che rappresenta una sala nel livello dei dati
public class Sala {
    private int maxPosti;   // Numero massimo di posti disponibili nella sala
    private int id;         // Identificativo unico della sala

    // Metodo getter per recuperare l'identificativo unico della sala
    public int getId() {
        return id;
    }

    // Metodo getter per recuperare il numero massimo di posti disponibili nella sala
    public int getMaxPosti() {
        return maxPosti;
    }

    // Metodo setter per impostare il numero massimo di posti disponibili nella sala
    public void setMaxPosti(int maxPosti) {
        this.maxPosti = maxPosti;
    }

    // Metodo setter per impostare l'identificativo unico della sala
    public void setId(int id) {
        this.id = id;
    }

}
