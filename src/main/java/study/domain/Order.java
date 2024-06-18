package study.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.FetchType.LAZY;

@Entity
@Getter @Setter
public class Order {

    @Id @GeneratedValue
    @Column(name="order_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "order", cascade = ALL)
    private List<OrderItem> orderItems = new ArrayList<>();

    private int totalPrice;

    public static Order creatOrder(Member member, OrderItem... orderItems) {
        Order order = new Order();
        order.setMember(member);
        int totalPrice = 0;
        for (OrderItem orderItem : orderItems) {
            order.addOrderItem(orderItem);
            totalPrice += orderItem.getPrice();
        }
        order.setTotalPrice(totalPrice);
        return order;
    }

    public void setMember(Member member) {
        this.member = member;
        member.getOrders().add(this);
    }

    public void addOrderItem(OrderItem orderItem) {
        this.orderItems.add(orderItem);
        orderItem.setOrder(this);
    }
}

