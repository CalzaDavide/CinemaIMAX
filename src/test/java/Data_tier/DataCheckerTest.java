package Data_tier;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

public class DataCheckerTest {

    @Test
    public void testCheckModeratoreData() throws SQLException {
        // Test case 1: Valid email
        assertTrue(DataChecker.checkModeratoreData("giacomo.favino@cinemaimax.it"));

        // Test case 2: Invalid email
        assertFalse(DataChecker.checkModeratoreData("invalid@example.com"));
    }

    @Test
    public void testCheckFilmData() throws SQLException {
        // Test case 1: Existing film title
        assertTrue(DataChecker.checkFilmData("Lethal Company"));

        // Test case 2: Non-existing film title
        assertFalse(DataChecker.checkFilmData("michele il guerriero"));
    }


    @Test
    public void testOrarioParser() {
        // Test case 1: Valid orario string
        String orario = "12:30:00";
        assertEquals(198, DataChecker.orarioParser(orario));


    }
}