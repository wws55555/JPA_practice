package study.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import static jakarta.persistence.FetchType.*;

@Entity
@Getter @Setter
@Table(name="order_item")
public class OrderItem {

    @Id @GeneratedValue
    @Column(name="order_item_id")
    private Long id;
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "order_id")
    private Order order;
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "item_id")
    private Item item;
    private int count;
    private int price;

    public static OrderItem createOrderItem(Item item, int count) {
        OrderItem orderItem = new OrderItem();
        orderItem.setItem(item);
        orderItem.setCount(count);
        orderItem.setPrice(orderItem.calculateOrderItemPrice());
        return orderItem;
    }

    public int calculateOrderItemPrice() {
        return this.getItem().getPrice() * this.getCount();
    }
}
