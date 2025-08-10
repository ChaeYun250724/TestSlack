package org.mbcboard.apiserver.models.mall.item.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.mbcboard.apiserver.constant.ItemCategory;
import org.mbcboard.apiserver.constant.ItemSaleStatus;
import org.mbcboard.apiserver.constant.ItemSellStatus;
import org.mbcboard.apiserver.core.BaseEntity;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="anpetna_item")
@Getter
@Setter
@ToString
public class Item extends BaseEntity {

    @Id
    @Column(name="itemId")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long itemId; // 상품코드

    @Column(nullable=false,length=50)
    private String itemName; // 상품명

    @Column(nullable=false)
    @Enumerated(EnumType.STRING)
    private ItemCategory itemCategory; // 카테고리

    @Column(nullable=false)
    private int itemStock; // 재고수량

    @Lob
    @Column(nullable=false)
    private String itemDetail; // 상품 상세설명

    @Enumerated(EnumType.STRING)
    private ItemSellStatus itemSellStatus; // 상품 판매상태
    @Enumerated(EnumType.STRING)
    private ItemSaleStatus itemSaleStatus; // 상품 할인상태

    private LocalDateTime itemRegiTime; // 등록시간
    private LocalDateTime itemModiTime; // 수정시간

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemImg> imageSet = new ArrayList<>();





   public void updateItem(ItemFormDTO itemFormDTO) {
       this.item_Nm = itemFormDTO.getItemNm();
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

    }//addStock() 종료


} // class종료
