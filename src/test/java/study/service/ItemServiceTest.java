package study.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import study.domain.Item;
import study.repository.ItemRepository;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class ItemServiceTest {
    @Autowired ItemService itemService;
    @Autowired ItemRepository itemRepository;

    @Test
    public void 등록(){
        Item item = new Item();
        item.setName("coffee");
        item.setPrice(2000);

        Long id = itemService.registerItem(item);

        assertEquals(item, itemRepository.selectItem(id));
    }
}