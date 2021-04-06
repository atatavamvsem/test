package by.gubko.sample.persistence;

import by.gubko.sample.domain.Order;

import java.util.Optional;

public class OrderStorage {

    public String persist(Order order) {
        throw new UnsupportedOperationException("not implemented yet");
    }

    public Optional<Order> allOrdersByUserId(String userId) {
        return Optional.empty();
    }
}
