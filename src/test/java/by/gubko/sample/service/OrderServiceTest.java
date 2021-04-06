package by.gubko.sample.service;

import by.gubko.sample.data.OrderDataTest;
import by.gubko.sample.domain.Order;
import by.gubko.sample.persistence.OrderItemStorage;
import by.gubko.sample.persistence.OrderStorage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.when;


class OrderServiceTest {

    private OrderService orderService;

    @Mock
    private OrderValidator orderValidator;

    @Mock
    private OrderStorage orderStorage;

    @Mock
    private OrderItemStorage orderItemStorage;

    private Order order;

    @BeforeEach
    public void before() {
        MockitoAnnotations.initMocks(this);
        orderService = new OrderService(orderValidator, orderStorage, orderItemStorage);
        order = OrderDataTest.anyOrder();
    }

    @Test
    void placeOrder_valid() {

        when(orderValidator.validateForCreation(order)).thenReturn(true);
        when(orderStorage.persist(order)).thenReturn(order.getId());
        when(orderItemStorage.persist(order)).thenReturn(order.getId());
        String orderId = orderService.placeOrder(order);

        assertThat(orderId, is(equalTo(order.getId())));
    }

    @Test
    void loadAllByUserId() {
        when(orderStorage.allOrdersByUserId(order.getUserId())).thenReturn(Optional.of(order));
    }
}