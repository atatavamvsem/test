package by.gubko.sample.service;

import by.gubko.sample.domain.Order;
import by.gubko.sample.domain.OrderStatus;
import by.gubko.sample.persistence.OrderItemStorage;
import by.gubko.sample.persistence.OrderStorage;

import java.util.Optional;

public class OrderService {

    private final OrderValidator orderValidator;
    private final OrderStorage orderStorage;
    private final OrderItemStorage orderItemStorage;

    public OrderService(OrderValidator orderValidator, OrderStorage orderStorage, OrderItemStorage orderItemStorage) {
        this.orderValidator = orderValidator;
        this.orderStorage = orderStorage;
        this.orderItemStorage = orderItemStorage;
    }

    public String placeOrder(Order order) {
        final boolean valid = orderValidator.validateForCreation(order);
        if (!valid) {
            throw new IllegalArgumentException("order is not valid " + order);
        }
        orderItemStorage.persist(order);
        final String orderId = orderStorage.persist(order);
        order.setStatus(OrderStatus.ACTIVE);
        return orderId;
    }

    public Optional<Order> loadAllByUserId(String userId) {
        Optional<Order> allOrders = orderStorage.allOrdersByUserId(userId);
        return allOrders;
    }
}
