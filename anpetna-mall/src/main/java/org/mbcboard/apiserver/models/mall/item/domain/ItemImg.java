package org.mbcboard.apiserver.models.mall.item.domain;

import jakarta.persistence.*;
import lombok.*;
import org.mbcboard.apiserver.core.BaseEntity;

@Entity
@Table(name="itemImg")
@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemImg extends BaseEntity {

    @Id
    @Column(name="itemImgId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long imgId;

    private String imgName; // 이미지 파일명
    private String oriImgName; // 원본 이미지 파일명
    private String imgUrl; //  이미지 조회 경로
    private String repimgYn; // 대표이미지 여부
    private String thumbYn; //썸네일 이미지 여부

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "itemId")
    private Item item;





    public void updateItemImg(String oriImgName, String imgName, String imgUrl){
        this.oriImgName = oriImgName;
        this.imgName = imgName;
        this.imgUrl = imgUrl;
    } //updateItemImg종료
} // class 종료
