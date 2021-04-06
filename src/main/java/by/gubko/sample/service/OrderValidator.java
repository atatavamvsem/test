package by.gubko.sample.service;

import by.gubko.sample.domain.Order;

public class OrderValidator {

    public boolean validateForCreation(Order order) {

        if (order.getUserId() == null) {
            return false;
        }

        if (order.getAddressDelivery() == null) {
            return false;
        }

        return true;
    }
}
