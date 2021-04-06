package by.gubko.sample.persistence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class OrderItemStorageTest {
    private OrderItemStorage orderItemStorage = new OrderItemStorage();

    @Test
    public void testPersist_null() {
        assertThrows(NullPointerException.class, () -> orderItemStorage.persist(null));
    }
}