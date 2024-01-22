package Data_tier;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.SQLException;

public class ConPoolTest {

    @Test
    public void testGetConnection() {
        try {
            Connection connection = ConPool.getConnection();
            assertNotNull(connection);
            assertFalse(connection.isClosed());
        } catch (SQLException e) {
            fail("Failed to get connection: " + e.getMessage());
        }
    }
}