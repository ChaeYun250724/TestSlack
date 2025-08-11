package com.anpetna.mall.item.repository;

import com.anpetna.mall.item.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
