package by.gubko.sample.domain;

import java.time.LocalDate;

public class Order {
    private final String id;
    private final String userId;
    private LocalDate dateOrder;
    private String addressDelivery;
    private OrderStatus status;
    private OrderItem[] listOrders;
    private int cost;

    public Order(String id, String userId) {
        this.id = id;
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public LocalDate getDateOrder() {
        return dateOrder;
    }

    public String getAddressDelivery() {
        return addressDelivery;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public OrderItem[] getListOrders() {
        return listOrders;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setDateOrder(LocalDate dateOrder) {
        this.dateOrder = dateOrder;
    }

    public void setAddressDelivery(String addressDelivery) {
        this.addressDelivery = addressDelivery;
    }

    public void setListOrders(OrderItem[] listOrders) {
        this.listOrders = listOrders;
    }
}
