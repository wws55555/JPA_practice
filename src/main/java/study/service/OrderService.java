package study.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.domain.Item;
import study.domain.Member;
import study.domain.Order;
import study.domain.OrderItem;
import study.repository.ItemRepository;
import study.repository.MemberRepository;
import study.repository.OrderRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {
    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;
    private final ItemRepository itemRepository;

    public Long order(Long member_id, Long item_id, int count) {
        Member findMember = memberRepository.selectMember(member_id);
        Item findItem = itemRepository.selectItem(item_id);

        OrderItem orderItem = OrderItem.createOrderItem(findItem, count);
        Order order = Order.creatOrder(findMember, orderItem);

        orderRepository.insertOrder(order);
        return order.getId();
    }
}
