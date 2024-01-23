package Data_tier;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SalaTest {

    @Test
    public void testSetMaxPosti() {
        Sala sala = new Sala();
        int maxPosti = 100;
        sala.setMaxPosti(maxPosti);
        assertEquals(maxPosti, sala.getMaxPosti());
    }

    @Test
    public void testSetId() {
        Sala sala = new Sala();
        int id = 1;
        sala.setId(id);
        assertEquals(id, sala.getId());
    }

    @Test
    public void testGetId() {
        Sala sala = new Sala();
        sala.setId(1);
        assertEquals(1, sala.getId());
    }

    @Test
    public void testGetMaxPosti() {
        Sala sala = new Sala();
        sala.setMaxPosti(100);
        assertEquals(100, sala.getMaxPosti());
    }

    @Test
    public void testGetPosti() {
        Sala sala = new Sala();
        sala.setMaxPosti(100);
        assertEquals(100, sala.getMaxPosti());
    }
}