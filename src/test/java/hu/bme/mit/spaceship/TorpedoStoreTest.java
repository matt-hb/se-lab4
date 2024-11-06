package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class TorpedoStoreTest {

    @Test
    void fire_Success() {
        // Arrange
        TorpedoStore store = new TorpedoStore(1);

        // Act
        boolean result = store.fire(1);

        // Assert
        assertEquals(true, result);
        assertEquals(true, store.isEmpty());
    }

    @Test
    void fire_Fail() {
        // Arrange
        TorpedoStore store = new TorpedoStore(1, 1.0);

        // Act
        boolean result = store.fire(1);

        // Assert
        assertEquals(false, result);
        assertEquals(1, store.getTorpedoCount());
    }

    @Test
    void fire_MoreThanStored() {
        // Arrange
        TorpedoStore store = new TorpedoStore(1);

        // Act, Assert
        assertThrows(IllegalArgumentException.class, () -> store.fire(2));
    }

    @Test
    void fire_Zero () {
        // Arrange
        TorpedoStore store = new TorpedoStore(1);

        // Act, Assert
        assertThrows(IllegalArgumentException.class, () -> store.fire(0));
    }

}
