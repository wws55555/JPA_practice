package study.repository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import study.domain.Item;

@Repository
@RequiredArgsConstructor
public class ItemRepository {
    private final EntityManager em;

    public void insertItem(Item item) {
        em.persist(item);
    }
    public Item selectItem(Long id) {
        return em.find(Item.class, id);
    }
}
