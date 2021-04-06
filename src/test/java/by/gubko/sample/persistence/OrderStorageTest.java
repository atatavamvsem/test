package by.gubko.sample.persistence;

import by.gubko.sample.data.OrderDataTest;
import by.gubko.sample.domain.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

class OrderStorageTest {
    @Mock
    private OrderStorage orderStorage;

    private Order order;

    @BeforeEach
    public void before() {
        MockitoAnnotations.initMocks(this);
        order = OrderDataTest.anyOrder();
    }

    @Test
    void persist() {
        assertThrows(NullPointerException.class, () -> orderStorage.persist(null));
    }

    @Test
    void allOrdersByUserId() {
        when(orderStorage.allOrdersByUserId(order.getUserId())).thenReturn(Optional.empty());
    }
}