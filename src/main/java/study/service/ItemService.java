package study.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.domain.Item;
import study.repository.ItemRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class ItemService {
    private final ItemRepository itemRepository;

    public Long registerItem(Item item) {
        itemRepository.insertItem(item);
        return item.getId();
    }
}
