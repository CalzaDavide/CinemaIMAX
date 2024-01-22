package Data_tier;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.ArrayList;

public class ModeratoreDAOTest {

    @Test
    public void testAddModeratore() {
        ModeratoreDAO moderatoreDAO = new ModeratoreDAO();
        Moderatore moderatore = new Moderatore();
        moderatore.setNome("Test");
        moderatore.setCognome("Moderatore");
        moderatore.setPassword("test123");
        moderatore.setEmail("test@test.com");

        try {
            moderatoreDAO.addModeratore(moderatore);
            // Assert that the moderatore was added successfully
            assertNotNull(moderatoreDAO.doRetriveByEmailPass(moderatore.getEmail(), moderatore.getPassword()));
        } catch (SQLException e) {
            fail("Failed to add moderatore: " + e.getMessage());
        }
    }

    @Test
    public void testUpdatePassword() {
        ModeratoreDAO moderatoreDAO = new ModeratoreDAO();
        String email = "test@test.com";
        String newPassword = "newpassword";

        try {
            moderatoreDAO.updatePassword(email, newPassword);
            // Assert that the password was updated successfully
            Moderatore moderatore = moderatoreDAO.doRetriveByEmailPass(email, newPassword);
            assertNotNull(moderatore);
            assertEquals(newPassword, moderatore.getPassword());
        } catch (SQLException e) {
            fail("Failed to update password: " + e.getMessage());
        }
    }

    @Test
    public void testDoDeleteById() {
        ModeratoreDAO moderatoreDAO = new ModeratoreDAO();
        int id = 1;

        try {
            boolean result = moderatoreDAO.doDeleteById(id);
            // Assert that the moderatore was deleted successfully
            assertTrue(result);
            assertNull(moderatoreDAO.doRetriveByEmailPass("email", "pass"));
        } catch (SQLException e) {
            fail("Failed to delete moderatore by id: " + e.getMessage());
        }
    }

    @Test
    public void testDoRetriveByEmailPass() {
        ModeratoreDAO moderatoreDAO = new ModeratoreDAO();
        String email = "moderatore@a.a";
        String password = "moderatore";

        try {
            Moderatore moderatore = moderatoreDAO.doRetriveByEmailPass(email, password);
            assertNotNull(moderatore);
            assertEquals(email, moderatore.getEmail());
            assertEquals(password, moderatore.getPassword());
        } catch (SQLException e) {
            fail("Failed to retrieve moderatore by email and password: " + e.getMessage());
        }
    }

    @Test
    public void testDoRetrieveModeratori() {
        ModeratoreDAO moderatoreDAO = new ModeratoreDAO();

        try {
            ArrayList<Moderatore> moderatori = moderatoreDAO.doRetrieveModeratori();
            assertNotNull(moderatori);
            assertFalse(moderatori.isEmpty());
        } catch (Exception e) {
            fail("Failed to retrieve moderatori: " + e.getMessage());
        }
    }
}