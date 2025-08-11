package com.anpetna.mall.item.entity;

import com.anpetna.core.BaseEntity;
import com.anpetna.core.ImageEntity;
import com.anpetna.mall.item.constant.ItemSellStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="item")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Item extends BaseEntity {

    @Id
    @Column(name="itemId")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long itemId; // 상품코드

    @Column(nullable=false,length=50)
    private String itemNm; // 상품명

    @Column(name="price", nullable=false)
    private int price; // 가격

    @Column(nullable=false)
    private int stockNumber; // 재고수량

    @Lob
    @Column(nullable=false)
    private String itemDetail; // 상품 상세설명

    @Enumerated(EnumType.STRING)
    private ItemSellStatus itemSellStatus; // 상품 판매상태

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ImageEntity> itemImages = new ArrayList<>();

    public void addItemImage(ImageEntity imageEntity) {
        this.itemImages.add(imageEntity); // Collection 메서드 //조회용 객체
        imageEntity.setItem(this);//manyToOne활성화
    }

/*    public void updateItem(ItemFormDTO itemFormDTO) {
        this.itemNm = itemFormDTO.getItemNm();
        this.price = itemFormDTO.getPrice();
        this.stockNumber = itemFormDTO.getStockNumber();
        this.itemDetail = itemFormDTO.getItemDetail();
        this.itemSellStatus = itemFormDTO.getItemSellStatus();
    }//updateItem 종료

    public void removeStock(int stockNumber){
        //상품 주문시 재고 감소
        int restStock = this.stockNumber - stockNumber;
        if(restStock < 0){
            throw new OutOfStockException("상품의 재고가 부족합니다, (현재 재고 수량: "+this.stockNumber);
        } // if종료
        this.stockNumber = restStock;

    } // removeStock 종료

    public void addStock(int stockNumber){
        // 상품의 재고를 증가
        this.stockNumber += stockNumber;
    }//addStock() 종료*/


} // class종료
