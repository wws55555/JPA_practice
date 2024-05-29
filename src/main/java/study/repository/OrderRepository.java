package study.repository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import study.domain.Order;

@Repository
@RequiredArgsConstructor
public class OrderRepository {
    private final EntityManager em;

    public void insertOrder(Order order) {
        em.persist(order);
    }

    public Order selectOrder(Long id) {
        return em.find(Order.class, id);
    }
}
