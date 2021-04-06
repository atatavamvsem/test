package by.gubko.sample.data;

import by.gubko.sample.domain.Order;
import by.gubko.sample.domain.OrderItem;
import by.gubko.sample.domain.OrderStatus;

import java.time.LocalDate;
import java.util.UUID;

public class OrderDataTest {
    public static Order validOrder(String id, String userId){
        Order order = new Order(id, userId);
        order.setStatus(OrderStatus.INITIALIZED);
        order.setAddressDelivery("Minsk, Lenina str., 87/1");
        order.setDateOrder(LocalDate.now());
        order.setListOrders(new OrderItem[]{new OrderItem()});

        return order;
    }

    public static Order anyOrder(){
        return validOrder(UUID.randomUUID().toString(),UUID.randomUUID().toString());
    }
}
