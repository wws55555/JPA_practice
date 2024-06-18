package study.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import study.domain.*;
import study.repository.OrderRepository;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class OrderServiceTest {
    @Autowired OrderService orderService;
    @Autowired OrderRepository orderRepository;

    @Test
    void calculateOrderItemPrice() {
        OrderItem orderItem = new OrderItem();
        Item item = new Item();
        item.setName("아메리카노");
        item.setPrice(2000);
        orderItem.setItem(item);
        orderItem.setCount(2);

        int price = orderItem.calculateOrderItemPrice();

        assertEquals(price, 4000);
    }

    @Test
    void createOrderItem() {
        Item item = new Item();
        item.setName("아메리카노");
        item.setPrice(2000);
        int count = 2;

        OrderItem orderItem = OrderItem.createOrderItem(item, count);

        assertEquals(orderItem.getPrice(), 4000);
    }

    @Test
    void creatOrder() {
        Item item1 = new Item();
        item1.setName("아메리카노");
        item1.setPrice(2000);
        int count1 = 2;
        OrderItem orderItem1 = OrderItem.createOrderItem(item1, count1);

        Item item2 = new Item();
        item2.setName("카페라떼");
        item2.setPrice(3000);
        int count2 = 1;
        OrderItem orderItem2 = OrderItem.createOrderItem(item2, count2);

        Member member = new Member();
        member.setName("kim");

        Order order = Order.creatOrder(member, orderItem1, orderItem2);

        assertEquals(order.getTotalPrice(), 7000);
        for (OrderItem orderItem : order.getOrderItems()) {
            System.out.println(orderItem.getItem().getName());
        }
    }

}