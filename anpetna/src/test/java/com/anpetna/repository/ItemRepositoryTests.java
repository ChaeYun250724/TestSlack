package com.anpetna.repository;

import com.anpetna.mall.item.entity.Item;
import com.anpetna.mall.item.repository.ItemRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class ItemRepositoryTests {

    @Autowired
    ItemRepository itemRepository;

    @Test
    public void addItemImage() {
        Item item = Item.builder()
                .itemId(1L)
                .itemNm("이름")

                .build();
    }
}
