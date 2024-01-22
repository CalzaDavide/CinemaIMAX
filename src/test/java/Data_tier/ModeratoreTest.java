package Data_tier;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ModeratoreTest {

    @Test
    public void testSetAndGetId() {
        Moderatore moderatore = new Moderatore();
        moderatore.setId(1);
        int id = moderatore.getId();
        Assertions.assertEquals(1, id);
    }

    @Test
    public void testSetAndGetEmail() {
        Moderatore moderatore = new Moderatore();
        moderatore.setEmail("example@example.com");
        String email = moderatore.getEmail();
        Assertions.assertEquals("example@example.com", email);
    }

    @Test
    public void testSetAndGetPassword() {
        Moderatore moderatore = new Moderatore();
        moderatore.setPassword("password123");
        String password = moderatore.getPassword();
        Assertions.assertEquals("password123", password);
    }

    @Test
    public void testSetAndGetNome() {
        Moderatore moderatore = new Moderatore();
        moderatore.setNome("John");
        String nome = moderatore.getNome();
        Assertions.assertEquals("John", nome);
    }

    @Test
    public void testSetAndGetCognome() {
        Moderatore moderatore = new Moderatore();
        moderatore.setCognome("Doe");
        String cognome = moderatore.getCognome();
        Assertions.assertEquals("Doe", cognome);
    }

    @Test
    public void testSetAndGetAdmin() {
        Moderatore moderatore = new Moderatore();
        moderatore.setAdmin(true);
        boolean isAdmin = moderatore.isAdmin();
        Assertions.assertTrue(isAdmin);
    }

    @Test
    public void testModificaEmail() {
        Moderatore moderatore = new Moderatore();
        moderatore.setEmail("example@example.com");
        moderatore.modificaEmail("new@example.com");
        String email = moderatore.getEmail();
        Assertions.assertEquals("new@example.com", email);
    }

    @Test
    public void testModificaPassword() {
        Moderatore moderatore = new Moderatore();
        moderatore.setPassword("password123");
        moderatore.modificaPassword("newpassword123");
        String password = moderatore.getPassword();
        Assertions.assertEquals("newpassword123", password);
    }
}